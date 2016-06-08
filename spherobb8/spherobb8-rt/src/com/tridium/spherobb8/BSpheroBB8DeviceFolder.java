/*
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8;

import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BSpheroBB8DeviceFolder is a folder for BSpheroBB8Device.
 *
 *  @author   Aaron D'souza
 *  @creation 24-May-16 
 */
//@NiagaraSlots( properties = { } )
public class BSpheroBB8DeviceFolder
  extends BNDeviceFolder
{                       
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
  
////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8DeviceFolder.class); 

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BSpheroBB8Network.
   * @return network as a BSpheroBB8Network.
   */
  public final BSpheroBB8Network getSpheroBB8Network()
  {
    return (BSpheroBB8Network)getNetwork();
  }
  
  /**
   * @return true if parent is BSpheroBB8Network or BSpheroBB8DeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BSpheroBB8Network ||
           parent instanceof BSpheroBB8DeviceFolder;
  }


}
