/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.lifx.point;

import javax.baja.sys.*;
import javax.baja.driver.point.*;

import com.tridium.lifx.*;
import javax.baja.nre.annotations.*;

/**
 * BLifxPointFolder
 *
 * @author   Aaron D'souza
 * @creation 05-Jun-16  
 */
//@NiagaraSlots( properties = { } )
public class BLifxPointFolder
  extends BPointFolder
{            
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxPointFolder.class); 

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
  
  /**
   * Get the network cast to a BLifxNetwork.
   * @return network as a BLifxNetwork.
   */
  public final BLifxNetwork getLifxNetwork()
  {
    return (BLifxNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BLifxDevice.
   * @return device as a BLifxDevice.
   */
  public final BLifxDevice getLifxDevice()
  {
    return (BLifxDevice)getDevice();
  }

}
