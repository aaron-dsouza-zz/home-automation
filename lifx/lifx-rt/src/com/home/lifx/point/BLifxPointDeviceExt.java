/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.home.lifx.point;

import javax.baja.sys.*;


import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.point.*;

/**
 * BLifxPointDeviceExt is a container for lifx proxy points.
 *
 * @author   Aaron D'souza
 * @creation 05-Jun-16 
 */
//@NiagaraSlots( properties = { } )
public class BLifxPointDeviceExt


  extends BNPointDeviceExt 
{            
  public static final Property discoveryPreferences = newProperty(0, new BLifxPointDiscoveryPreferences(),null);


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxPointDeviceExt.class); 

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
  
  /**
   * Get the network cast to a BLifxNetwork.
   * @return network as a BLifxNetwork.
   */
  public final com.home.lifx.BLifxNetwork getLifxNetwork()
  {
    return (com.home.lifx.BLifxNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BLifxDevice.
   * @return device as a BLifxDevice.
   */
  public final com.home.lifx.BLifxDevice getLifxDevice()
  {
    return (com.home.lifx.BLifxDevice)getDevice();
  }

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////
  
  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return com.home.lifx.BLifxDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BLifxPointFolder.TYPE;
  }
  
  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BLifxProxyExt.TYPE;
  }
  

////////////////////////////////////////////////////////////////
//BINDiscoveryHost
////////////////////////////////////////////////////////////////

  /** Call back for discoveryJob to get an array of discovery objects.
   *  Override point for driver specific discovery. */
  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs) 
      throws Exception
  {
     //
     // TODO  get array of discovery objects
     //
//    Array a = new Array(??.class);
//    for(??)
//     a.add(new BLifxPointDiscoveryLeaf(??));
//    return (??[])a.trim();
    return null;
  }

}
