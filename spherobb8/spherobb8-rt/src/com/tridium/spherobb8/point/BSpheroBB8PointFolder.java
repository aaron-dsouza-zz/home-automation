/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.point;

import javax.baja.sys.*;
import javax.baja.driver.point.*;

import com.tridium.spherobb8.*;
import javax.baja.nre.annotations.*;

/**
 * BSpheroBB8PointFolder
 *
 * @author   Aaron D'souza
 * @creation 24-May-16  
 */
//@NiagaraSlots( properties = { } )
public class BSpheroBB8PointFolder
  extends BPointFolder
{            
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8PointFolder.class); 

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

}
