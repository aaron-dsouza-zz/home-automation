/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.home.lifx;

//import javax.baja.license.Feature;
import javax.baja.naming.BOrd;
import javax.baja.nre.util.Array;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;
import javax.baja.nre.annotations.*;

import com.home.lifx.comm.BLifxUDPCommConfig;
import com.home.lifx.learn.BLifxDeviceDiscoveryLeaf;
import com.home.lifx.learn.BLifxDeviceDiscoveryPreferences;
import com.home.lifx.message.LifxGetService;
import com.home.lifx.message.LifxStateService;
import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;


/**
 *  BLifxNetwork models a network of devices
 *
 *  @author   Aaron D'souza
 *  @creation 05-Jun-16 
 */
@NiagaraSlots(
  properties = {
    @NiagaraProperty(name = "pollScheduler", type = "BNPollScheduler",  defaultValue = "new BNPollScheduler()"),
    @NiagaraProperty(name = "udpConfig", type = "BLifxUDPCommConfig",  defaultValue = "new BLifxUDPCommConfig()"),
    @NiagaraProperty(name = "discoveryPreferences", type = "BNDiscoveryPreferences",  defaultValue = "new BLifxDeviceDiscoveryPreferences()", flags = Flags.HIDDEN),
  },
 actions = {
   @NiagaraAction(name="submitDiscoveryJob", defaultValue = "new BLifxDeviceDiscoveryPreferences()", 
                  parameterType = "BNDiscoveryPreferences", returnType = "BOrd", flags = Flags.HIDDEN)
 }  

)
public class BLifxNetwork 
  extends BNNetwork
  implements BINDiscoveryHost
{

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.home.lifx.BLifxNetwork(591747123)1.0$ @*/
/* Generated Sun Jun 12 01:07:10 IST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pollScheduler"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pollScheduler} property.
   * @see #getPollScheduler
   * @see #setPollScheduler
   */
  public static final Property pollScheduler = newProperty(0, new BNPollScheduler(), null);
  
  /**
   * Get the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }
  
  /**
   * Set the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public void setPollScheduler(BNPollScheduler v) { set(pollScheduler, v, null); }

////////////////////////////////////////////////////////////////
// Property "udpConfig"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code udpConfig} property.
   * @see #getUdpConfig
   * @see #setUdpConfig
   */
  public static final Property udpConfig = newProperty(0, new BLifxUDPCommConfig(), null);
  
  /**
   * Get the {@code udpConfig} property.
   * @see #udpConfig
   */
  public BLifxUDPCommConfig getUdpConfig() { return (BLifxUDPCommConfig)get(udpConfig); }
  
  /**
   * Set the {@code udpConfig} property.
   * @see #udpConfig
   */
  public void setUdpConfig(BLifxUDPCommConfig v) { set(udpConfig, v, null); }

////////////////////////////////////////////////////////////////
// Property "discoveryPreferences"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code discoveryPreferences} property.
   * @see #getDiscoveryPreferences
   * @see #setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(Flags.HIDDEN, new BLifxDeviceDiscoveryPreferences(), null);
  
  /**
   * Get the {@code discoveryPreferences} property.
   * @see #discoveryPreferences
   */
  public BNDiscoveryPreferences getDiscoveryPreferences() { return (BNDiscoveryPreferences)get(discoveryPreferences); }
  
  /**
   * Set the {@code discoveryPreferences} property.
   * @see #discoveryPreferences
   */
  public void setDiscoveryPreferences(BNDiscoveryPreferences v) { set(discoveryPreferences, v, null); }

////////////////////////////////////////////////////////////////
// Action "submitDiscoveryJob"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code submitDiscoveryJob} action.
   * @see #submitDiscoveryJob(BNDiscoveryPreferences parameter)
   */
  public static final Action submitDiscoveryJob = newAction(Flags.HIDDEN, new BLifxDeviceDiscoveryPreferences(), null);
  
  /**
   * Invoke the {@code submitDiscoveryJob} action.
   * @see #submitDiscoveryJob
   */
  public BOrd submitDiscoveryJob(BNDiscoveryPreferences parameter) { return (BOrd)invoke(submitDiscoveryJob, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxNetwork.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
  
   

  /** Specify name for network resources. */
  public String getNetworkName() { return "LifxNetwork"; }

  /** return device folder type  */
  @Override
  public Type getDeviceFolderType()
  {
    return BLifxDeviceFolder.TYPE;
  }

  /** return device type */
  @Override
  public Type getDeviceType()
  {
    return BLifxDevice.TYPE;
  }
  
  /** TODO - Add license check if needed
  @Override
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */
  
  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if(!isRunning()) return;

    if(p == status)
    {
      // Give any comms opportunity to respond to status changes
      getUdpConfig().statusUpdate();
  
    }
  }
  

  
  
////////////////////////////////////////////////////////////////
//BINDiscoveryHost
////////////////////////////////////////////////////////////////

  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs) 
     throws Exception
  {
    Array discoveredLifxDevices = new Array(com.home.lifx.learn.BLifxDeviceDiscoveryLeaf.class);
    BIpAddress udpBroadcastAddress = new BIpAddress("192.168.1.255", getUdpConfig().getAddress().getPort());
    LifxGetService getServiceMsg = new LifxGetService(udpBroadcastAddress);
    NMessage response = ((NComm)getUdpConfig().comm()).sendRequest(getServiceMsg);
    System.out.println("Response received");
    if(response instanceof LifxStateService) {
      LifxStateService stateService = (LifxStateService) response;
      BLifxDeviceDiscoveryLeaf leaf = new BLifxDeviceDiscoveryLeaf();
      leaf.setMacAddress(stateService.target);
      leaf.getIpAddress().setIpAddress(stateService.getIpAddress());
      leaf.getIpAddress().setPort((int) stateService.getPort());
      discoveredLifxDevices.add(leaf);
    }
    return (com.home.lifx.learn.BLifxDeviceDiscoveryLeaf[]) discoveredLifxDevices.trim();
  }
  
  public BOrd doSubmitDiscoveryJob(BNDiscoveryPreferences preferences)
  {
    // Saves the most recent device discovery parameters
    setDiscoveryPreferences((com.home.lifx.learn.BLifxDeviceDiscoveryPreferences)preferences.newCopy());
    // Instantiates an instance of BNDiscoveryJob
    BNDiscoveryJob job = new BNDiscoveryJob(this);
    // Passes the discovery parameters to the job
    job.setDiscoveryPreferences(preferences);
    // Submits the job and returns Ord 
    return job.submit(null);
  }


////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////
  
  
  
   /** Access the udp comm stack */
  public NComm ucomm() 
  {
    return (NComm)getUdpConfig().comm();
  }
  
  
  
  public static Lexicon LEX = Lexicon.make(BLifxNetwork.class);

}
