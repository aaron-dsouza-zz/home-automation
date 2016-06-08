/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.status.BStatus;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import com.tridium.spherobb8.point.*;


/**
 *  BSpheroBB8Device models a single device
 *
 *  @author   Aaron D'souza
 *  @creation 24-May-16 
 */
@NiagaraSlots(
  properties = {
    @NiagaraProperty(name = "pollFrequency", type = "BPollFrequency",  defaultValue = "BPollFrequency.normal"),
    @NiagaraProperty(name = "points", type = "BSpheroBB8PointDeviceExt",  defaultValue = "new BSpheroBB8PointDeviceExt()"),
  }
)
public class BSpheroBB8Device
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
   * @see com.tridium.spherobb8.BSpheroBB8Device#getPollFrequency
   * @see com.tridium.spherobb8.BSpheroBB8Device#setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal,null);
  
  /**
   * Get the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.tridium.spherobb8.BSpheroBB8Device#pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }
  
  /**
   * Set the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.tridium.spherobb8.BSpheroBB8Device#pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency,v,null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>points</code> property.
   * @see com.tridium.spherobb8.BSpheroBB8Device#getPoints
   * @see com.tridium.spherobb8.BSpheroBB8Device#setPoints
   */
  public static final Property points = newProperty(0, new BSpheroBB8PointDeviceExt(),null);
  
  /**
   * Get the <code>points</code> property.
   * @see com.tridium.spherobb8.BSpheroBB8Device#points
   */
  public BSpheroBB8PointDeviceExt getPoints() { return (BSpheroBB8PointDeviceExt)get(points); }
  
  /**
   * Set the <code>points</code> property.
   * @see com.tridium.spherobb8.BSpheroBB8Device#points
   */
  public void setPoints(BSpheroBB8PointDeviceExt v) { set(points,v,null); }


////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8Device.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////
  
  /**
   * Returns the network type that the device runs on.
   * @return Type object representing the network
   */
  public Type getNetworkType() { return BSpheroBB8Network.TYPE; }  
  
  
  /**
   * Override started 
   */
  public void started()
    throws Exception
  {
    super.started();
    
    // register device with poll scheduler 
    getSpheroBB8Network().getPollScheduler().subscribe(this);
  }
  
  /**
   * Override stopped 
   */
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler 
    getSpheroBB8Network().getPollScheduler().unsubscribe(this);
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
   * Get the network cast to a BSpheroBB8Network.
   * @return network as a BSpheroBB8Network.
   */
  public final BSpheroBB8Network getSpheroBB8Network()
  {
    return (BSpheroBB8Network)getNetwork();
  }


  
}
