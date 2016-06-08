/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.point;

import javax.baja.sys.*;


import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.point.*;


import com.tridium.spherobb8.*;
import javax.baja.nre.annotations.*;

/**
 * BSpheroBB8PointDeviceExt is a container for spherobb8 proxy points.
 *
 * @author   Aaron D'souza
 * @creation 24-May-16 
 */
//@NiagaraSlots( properties = { } )
public class BSpheroBB8PointDeviceExt


  extends BNPointDeviceExt 
{            
  public static final Property discoveryPreferences = newProperty(0, new BSpheroBB8PointDiscoveryPreferences(),null);


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8PointDeviceExt.class); 

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
   * Get the device cast to a BSpheroBB8Device.
   * @return device as a BSpheroBB8Device.
   */
  public final BSpheroBB8Device getSpheroBB8Device()
  {
    return (BSpheroBB8Device)getDevice();
  }

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////
  
  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BSpheroBB8Device.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BSpheroBB8PointFolder.TYPE;
  }
  
  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BSpheroBB8ProxyExt.TYPE;
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
//     a.add(new BSpheroBB8PointDiscoveryLeaf(??));
//    return (??[])a.trim();
    return null;
  }

}
