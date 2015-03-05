package org.eclipse.rcptt.tesla.jface;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.framework.Bundle;

public enum DescriptorInfo {
	BUNDLE_URL("URLImageDescriptor\\(((bundleentry|bundleresource).*)\\)") {
		@Override
		String extract(Matcher matcher) {
			String uriStr = matcher.group(1);
			URI bundleUri = null;
			try {
				bundleUri = new URI(uriStr);
			} catch (URISyntaxException e) {
				return "InvalidUri(" + uriStr + ")";
			}

			String host = bundleUri.getHost();
			int bundleIdEndIndex = host.indexOf(".fwk");
			if (bundleIdEndIndex == -1) {
				return "UnknownBundleId(" + uriStr + ")";
			}

			int bundleId = -1;
			try {
				bundleId = Integer.parseInt(host.substring(0, bundleIdEndIndex));
			} catch (NumberFormatException e) {
				return "UnknownBundleId(" + uriStr + ")";
			}

			Bundle imageBundle = JFaceAspectsActivator.getDefault().getBundle().getBundleContext()
					.getBundle(bundleId);
			String bundleName = imageBundle == null ? "unknownBundle" : imageBundle.getSymbolicName();
			return String.format("%s%s", bundleName, bundleUri.getPath());
		}
	},

	ABSOLUTE_URL("URLImageDescriptor\\((file:/|platform:/plugin/)(.*)\\)") {
		@Override
		String extract(Matcher matcher) {
			return matcher.group(2);
		}
	},

	FILE_CLASS("FileImageDescriptor\\(location=class (.*), name=(.*)\\)") {
		@Override
		String extract(Matcher matcher) {
			return String.format("%s%s", matcher.group(1), matcher.group(2));
		}
	};

	public final Pattern pattern;

	DescriptorInfo(String expression) {
		this.pattern = Pattern.compile(expression);
	}

	public static boolean isValid(String str) {
		for (DescriptorInfo i : DescriptorInfo.values()) {
			if (i.pattern.matcher(str).matches()) {
				return true;
			}
		}

		return false;
	}

	public static String getInfo(String str) {
		for (DescriptorInfo i : DescriptorInfo.values()) {
			Matcher matcher = i.pattern.matcher(str);
			if (matcher.matches()) {
				return i.extract(matcher);
			}
		}

		return str;
	}

	abstract String extract(Matcher matcher);
}
