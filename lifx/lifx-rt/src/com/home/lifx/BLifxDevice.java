/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.home.lifx;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.naming.BOrd;
import javax.baja.status.BStatus;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.home.lifx.message.LifxSetPower;
import com.home.lifx.paremeters.BSetPowerParameters;
import com.home.lifx.point.BLifxPointDeviceExt;
import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.comm.NComm;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;


/**
 * BLifxDevice models a single device
 *
 * @author Aaron D'souza
 * @creation 05-Jun-16
 */
@NiagaraSlots(
        properties = {
                @NiagaraProperty(name = "pollFrequency", type = "BPollFrequency", defaultValue = "BPollFrequency.normal"),
                @NiagaraProperty(name = "points", type = "BLifxPointDeviceExt", defaultValue = "new BLifxPointDeviceExt()"),
                @NiagaraProperty(name = "address", type = "BLifxAddress", defaultValue = "new BLifxAddress()"),
        },
        actions= {
        /**
         *  This is my action.  This comment will be included in the slot definition. Please note that this is a javaDoc comment.
         */
        @NiagaraAction
        (
            name = "setPowerLevel",                       // Name of the action.
            parameterType = "lifx:SetPowerParameters",    //Parameter type of the action. Supports "Module:Type" typespec format (preferred) or full name. Example: "baja:RelTime" or "BRelTime" are valid.
            defaultValue = "new BSetPowerParameters()"    //The default value of the action.
        )
}
)
public class BLifxDevice
        extends BNDevice
        implements BINPollable {

    // Add facet to include following in auto manager view
    public static final Property status = newProperty(Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));






/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.home.lifx.BLifxDevice(3095201420)1.0$ @*/
/* Generated Sat Jun 18 15:32:47 IST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pollFrequency"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);
  
  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }
  
  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BLifxPointDeviceExt(), null);
  
  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BLifxPointDeviceExt getPoints() { return (BLifxPointDeviceExt)get(points); }
  
  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BLifxPointDeviceExt v) { set(points, v, null); }

////////////////////////////////////////////////////////////////
// Property "address"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code address} property.
   * @see #getAddress
   * @see #setAddress
   */
  public static final Property address = newProperty(0, new BLifxAddress(), null);
  
  /**
   * Get the {@code address} property.
   * @see #address
   */
  public BLifxAddress getAddress() { return (BLifxAddress)get(address); }
  
  /**
   * Set the {@code address} property.
   * @see #address
   */
  public void setAddress(BLifxAddress v) { set(address, v, null); }

////////////////////////////////////////////////////////////////
// Action "setPowerLevel"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setPowerLevel} action.
   * This is my action.  This comment will be included in the slot definition. Please note that this is a javaDoc comment.
   * @see #setPowerLevel(BSetPowerParameters parameter)
   */
  public static final Action setPowerLevel = newAction(0, new BSetPowerParameters(), null);
  
  /**
   * Invoke the {@code setPowerLevel} action.
   * This is my action.  This comment will be included in the slot definition. Please note that this is a javaDoc comment.
   * @see #setPowerLevel
   */
  public void setPowerLevel(BSetPowerParameters parameter) { invoke(setPowerLevel, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxDevice.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////

    /**
     * Returns the network type that the device runs on.
     *
     * @return Type object representing the network
     */
    public Type getNetworkType() {
        return BLifxNetwork.TYPE;
    }


    /**
     * Override started
     */
    public void started()
            throws Exception {
        super.started();

        // register device with poll scheduler
        getLifxNetwork().getPollScheduler().subscribe(this);
    }

    /**
     * Override stopped
     */
    public void stopped()
            throws Exception {
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
    public void doPing() {
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
    public void doPoll() {
        // TODO add poll support
    }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////

    /**
     * Get the network cast to a BLifxNetwork.
     *
     * @return network as a BLifxNetwork.
     */
    public final BLifxNetwork getLifxNetwork() {
        return (BLifxNetwork) getNetwork();
    }

    @Override
    public BIcon getIcon() {
        return BIcon.make(BOrd.make("module://lifx/rc/bulb-icon.png"));
    }

    public void doSetPowerLevel(BSetPowerParameters parameters) throws Exception {
        LifxSetPower setPower = new LifxSetPower(getAddress(), parameters.getPowerLevel(), parameters.getDuration());
        NComm nComm = (NComm) getLifxNetwork().getUdpConfig().comm();
        nComm.sendMessage(setPower);
    }
}
