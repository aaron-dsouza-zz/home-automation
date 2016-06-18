/*
 * copyright 2012 Tridium, Inc. All Rights Reserved.
 */
package com.home.lifx.learn;

import javax.baja.sys.*;

import com.tridium.ndriver.discover.*;

//@NiagaraSlots
public class BLifxDeviceDiscoveryPreferences
  extends BNDiscoveryPreferences
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxDeviceDiscoveryPreferences.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  public Type getDiscoveryLeafType()
  {
    return BLifxDeviceDiscoveryLeaf.TYPE;
  }

}
