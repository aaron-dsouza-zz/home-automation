/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.lifx;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.status.BStatus;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import com.tridium.lifx.point.*;


/**
 *  BLifxDevice models a single device
 *
 *  @author   Aaron D'souza
 *  @creation 05-Jun-16 
 */
@NiagaraSlots(
  properties = {
    @NiagaraProperty(name = "pollFrequency", type = "BPollFrequency",  defaultValue = "BPollFrequency.normal"),
    @NiagaraProperty(name = "points", type = "BLifxPointDeviceExt",  defaultValue = "new BLifxPointDeviceExt()"),
  }
)
public class BLifxDevice
  extends BNDevice
  implements BINPollable
{
  
  // Add facet to include following in auto manager view
  public static final Property status = newProperty(Flags.TRANSIENT|Flags.READONLY|Flags.SUMMARY|Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Property "pollFrequency"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.tridium.lifx.BLifxDevice#getPollFrequency
   * @see com.tridium.lifx.BLifxDevice#setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal,null);
  
  /**
   * Get the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.tridium.lifx.BLifxDevice#pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }
  
  /**
   * Set the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.tridium.lifx.BLifxDevice#pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency,v,null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>points</code> property.
   * @see com.tridium.lifx.BLifxDevice#getPoints
   * @see com.tridium.lifx.BLifxDevice#setPoints
   */
  public static final Property points = newProperty(0, new BLifxPointDeviceExt(),null);
  
  /**
   * Get the <code>points</code> property.
   * @see com.tridium.lifx.BLifxDevice#points
   */
  public BLifxPointDeviceExt getPoints() { return (BLifxPointDeviceExt)get(points); }
  
  /**
   * Set the <code>points</code> property.
   * @see com.tridium.lifx.BLifxDevice#points
   */
  public void setPoints(BLifxPointDeviceExt v) { set(points,v,null); }


////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxDevice.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////
  
  /**
   * Returns the network type that the device runs on.
   * @return Type object representing the network
   */
  public Type getNetworkType() { return BLifxNetwork.TYPE; }  
  
  
  /**
   * Override started 
   */
  public void started()
    throws Exception
  {
    super.started();
    
    // register device with poll scheduler 
    getLifxNetwork().getPollScheduler().subscribe(this);
  }
  
  /**
   * Override stopped 
   */
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler 
    getLifxNetwork().getPollScheduler().unsubscribe(this);
    super.stopped();
  }
  
  
////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////
  /**
   * 
   */
  public void doPing() 
  { 
    // TODO - add ping implementation
    // if()
      pingOk();
    // else
    //  pingFail("not receiving response from device ");
  }
  

////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {
    // TODO add poll support
  }
  
////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////
  /**
   * Get the network cast to a BLifxNetwork.
   * @return network as a BLifxNetwork.
   */
  public final BLifxNetwork getLifxNetwork()
  {
    return (BLifxNetwork)getNetwork();
  }


  
}
