/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.lifx.point;

import javax.baja.sys.*;
import javax.baja.status.*;
import javax.baja.driver.point.*;
import javax.baja.nre.annotations.*;

import com.tridium.lifx.*;
import com.tridium.driver.util.DrUtil;


/**
 * BLifxProxyExt
 *
 *  @author   Aaron D'souza
 * @creation 05-Jun-16 
 */
//@NiagaraSlots( properties = { } )
public class BLifxProxyExt
  extends BProxyExt
{   
  
  // Override ProxyExt default status to clear stale state.
  // public static final Property status = newProperty(Flags.READONLY|Flags.TRANSIENT, BStatus.ok, null);
  
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxProxyExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
  
  /**
   * Get the network cast to a BLifxNetwork.
   */
  public final BLifxNetwork getLifxNetwork()
  {
    return (BLifxNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BLifxDevice.
   */
  public final BLifxDevice getBLifxDevice()
  {
    return (BLifxDevice)DrUtil.getParent(this, BLifxDevice.TYPE);
  }

  /**
   * Get the point device ext cast to a BLifxPointDeviceExt.
   */
  public final BLifxPointDeviceExt getLifxPointDeviceExt()
  {
    return (BLifxPointDeviceExt)getDeviceExt();
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
    return BLifxPointDeviceExt.TYPE;
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
