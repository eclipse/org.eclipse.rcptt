package org.eclipse.rcptt.tesla.nebula.nattable;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcptt.tesla.internal.ui.BasicElementMapper;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTablePartElement;

public class NatTableMapper extends BasicElementMapper<NatTablePartElement> {

	private static Map<String, NatTableMapper> mappers = new HashMap<String, NatTableMapper>();

	public synchronized static NatTableMapper getMapper(String id) {
		NatTableMapper swtElementMapper = mappers.get(id);
		if (swtElementMapper == null) {
			swtElementMapper = new NatTableMapper();
			mappers.put(id, swtElementMapper);
		}
		return swtElementMapper;
	}

	public synchronized static void remove(String id) {
		mappers.remove(id);
	}

}
