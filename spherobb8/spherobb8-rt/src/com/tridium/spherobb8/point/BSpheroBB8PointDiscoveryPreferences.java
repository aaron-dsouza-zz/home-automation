/*
 * copyright 2012 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.point;

import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.discover.*;

//@NiagaraSlots( properties = { } )
public class BSpheroBB8PointDiscoveryPreferences
  extends BNDiscoveryPreferences
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8PointDiscoveryPreferences.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  public Type getDiscoveryLeafType()
  {
    return BSpheroBB8PointDiscoveryLeaf.TYPE;
  }

}
