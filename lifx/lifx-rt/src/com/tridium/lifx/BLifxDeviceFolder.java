/*
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.lifx;

import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BLifxDeviceFolder is a folder for BLifxDevice.
 *
 *  @author   Aaron D'souza
 *  @creation 05-Jun-16 
 */
//@NiagaraSlots( properties = { } )
public class BLifxDeviceFolder
  extends BNDeviceFolder
{                       
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
  
////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxDeviceFolder.class); 

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
   * @return true if parent is BLifxNetwork or BLifxDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BLifxNetwork ||
           parent instanceof BLifxDeviceFolder;
  }


}
