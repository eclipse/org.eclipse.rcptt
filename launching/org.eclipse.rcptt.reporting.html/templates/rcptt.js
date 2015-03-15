function installDetailsWorkaround() {
	var nodes = document.getElementsByTagName("details")
  	for (var i=0; i<nodes.length; i++) {
    //console.log(i, nodes[i]);
		installCollapse(nodes[i]);
	}
}

function getContent(detailsNode) {
	var children = detailsNode.children;
	for (var i=0; i<children.length; i++) {
		if (children[i].tagName == 'SUMMARY')
			continue;
		return children[i];		
	}     
	return null;
}

function hasClass( elem, name ) {
	return ( " " + elem.className + " " ).indexOf( " " + name + " " ) >= 0;
}

function addClass( elem, name ) {
	if ( !hasClass( elem, name ) ) {
		elem.className += ( elem.className ? " " : "" ) + name;
	}
}

function toggleClass( elem, name ) {
	if ( hasClass( elem, name ) ) {
		removeClass( elem, name );
	} else {
		addClass( elem, name );
	}
}

function removeClass( elem, name ) {
	var set = " " + elem.className + " ";

	// Class name may appear multiple times
	while ( set.indexOf( " " + name + " " ) >= 0 ) {
		set = set.replace( " " + name + " ", " " );
	}

	// trim for prettiness
	elem.className = typeof set.trim === "function" ? set.trim() : set.replace( /^\s+|\s+$/g, "" );
}

function toggleDetails(detailsNode) {
	toggleClass(detailsNode, "closed");
}

function installCollapse(detailsNode) {
	var children = detailsNode.children;
	for (var i=0; i<children.length; i++) {     
		var child = children[i];
		if (child.tagName != 'SUMMARY')
			continue;
		child.addEventListener('click', function() {
			toggleDetails(detailsNode);
		});
		break;
	}
}

