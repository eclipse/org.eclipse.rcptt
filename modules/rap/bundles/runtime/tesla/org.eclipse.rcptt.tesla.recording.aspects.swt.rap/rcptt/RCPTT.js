rcptt = {
  define: function( name, object ) {
    var splits = name.split( "." );
    var parent = window;
    var part = splits[ 0 ];
    for( var i = 0, len = splits.length - 1; i < len; i++, part = splits[ i ] ) {
      if( !parent[ part ] ) {
        parent = parent[ part ] = {};
      } else {
        parent = parent[ part ];
      }
    }
    if( !( part in parent ) ) {
      parent[ part ] = object || {};
    }
    return part;
  }

};

var namespace = rcptt.define;