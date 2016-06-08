/*
 * copyright 2012 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.learn;

import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.discover.*;

//@NiagaraSlots
public class BSpheroBB8DeviceDiscoveryPreferences
  extends BNDiscoveryPreferences
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8DeviceDiscoveryPreferences.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  public Type getDiscoveryLeafType()
  {
    return BSpheroBB8DeviceDiscoveryLeaf.TYPE;
  }

}
