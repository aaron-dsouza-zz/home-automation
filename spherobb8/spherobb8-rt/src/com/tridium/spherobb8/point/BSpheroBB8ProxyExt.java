/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.point;

import javax.baja.sys.*;
import javax.baja.status.*;
import javax.baja.driver.point.*;
import javax.baja.nre.annotations.*;

import com.tridium.spherobb8.*;
import com.tridium.driver.util.DrUtil;


/**
 * BSpheroBB8ProxyExt
 *
 *  @author   Aaron D'souza
 * @creation 24-May-16 
 */
//@NiagaraSlots( properties = { } )
public class BSpheroBB8ProxyExt
  extends BProxyExt
{   
  
  // Override ProxyExt default status to clear stale state.
  // public static final Property status = newProperty(Flags.READONLY|Flags.TRANSIENT, BStatus.ok, null);
  
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8ProxyExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
  
  /**
   * Get the network cast to a BSpheroBB8Network.
   */
  public final BSpheroBB8Network getSpheroBB8Network()
  {
    return (BSpheroBB8Network)getNetwork();
  }

  /**
   * Get the device cast to a BSpheroBB8Device.
   */
  public final BSpheroBB8Device getBSpheroBB8Device()
  {
    return (BSpheroBB8Device)DrUtil.getParent(this, BSpheroBB8Device.TYPE);
  }

  /**
   * Get the point device ext cast to a BSpheroBB8PointDeviceExt.
   */
  public final BSpheroBB8PointDeviceExt getSpheroBB8PointDeviceExt()
  {
    return (BSpheroBB8PointDeviceExt)getDeviceExt();
  }
  
////////////////////////////////////////////////////////////////
// ProxyExt
////////////////////////////////////////////////////////////////
  public void readSubscribed(Context cx)
    throws Exception
  {
    // TODO
  }
  
  public void readUnsubscribed(Context cx)
    throws Exception
  {
     // TODO
  }
  
  public boolean write(Context cx)
    throws Exception
  {
    // TODO
    return false;
  }
  
  /**
   * Return the device type. 
   */
  public Type getDeviceExtType()
  {
    return BSpheroBB8PointDeviceExt.TYPE;
  }                     
  
  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO
    return BReadWriteMode.readonly;
  }                        
  
  public boolean isBoolean()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusBoolean;
  }
  
  public boolean isNumeric()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusNumeric;
  }
  
  public boolean isString()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusString;
  }
  
  public boolean isEnum()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusEnum;
  }
  
}
