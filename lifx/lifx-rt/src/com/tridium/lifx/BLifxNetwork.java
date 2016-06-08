/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.lifx;

//import javax.baja.license.Feature;
import javax.baja.naming.BOrd;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;
import com.tridium.lifx.learn.BLifxDeviceDiscoveryPreferences;



/**
 *  BLifxNetwork models a network of devices
 *
 *  @author   Aaron D'souza
 *  @creation 05-Jun-16 
 */
@NiagaraSlots(
  properties = {
    @NiagaraProperty(name = "pollScheduler", type = "BNPollScheduler",  defaultValue = "new BNPollScheduler()"),
    @NiagaraProperty(name = "udpConfig", type = "BUdpCommConfig",  defaultValue = "new BUdpCommConfig()"),
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
  
////////////////////////////////////////////////////////////////
//Property "pollScheduler"
////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>pollScheduler</code> property.
     * @see com.tridium.lifx.BLifxNetwork#getPollScheduler
     * @see com.tridium.lifx.BLifxNetwork#setPollScheduler
     */
    public static final Property pollScheduler = newProperty(0, new BNPollScheduler(),null);
    
    /**
     * Get the <code>pollScheduler</code> property.
     * @see com.tridium.lifx.BLifxNetwork#pollScheduler
     */
    public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }
    
    /**
     * Set the <code>pollScheduler</code> property.
     * @see com.tridium.lifx.BLifxNetwork#pollScheduler
     */
    public void setPollScheduler(BNPollScheduler v) { set(pollScheduler,v,null); }

  
  ////////////////////////////////////////////////////////////////
  // Property "udpConfig"
  ////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>udpConfig</code> property.
     * @see com.tridium.lifx.BLifxNetwork#getUdpConfig
     * @see com.tridium.lifx.BLifxNetwork#setUdpConfig
     */
    public static final Property udpConfig = newProperty(0, new BUdpCommConfig(),null);
    
    /**
     * Get the <code>udpConfig</code> property.
     * @see com.tridium.lifx.BLifxNetwork#udpConfig
     */
    public BUdpCommConfig getUdpConfig() { return (BUdpCommConfig)get(udpConfig); }
    
    /**
     * Set the <code>udpConfig</code> property.
     * @see com.tridium.lifx.BLifxNetwork#udpConfig
     */
    public void setUdpConfig(BUdpCommConfig v) { set(udpConfig,v,null); }

  ////////////////////////////////////////////////////////////////
  // Property "discoveryPreferences"
  ////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>discoveryPreferences</code> property.
   * @see com.tridium.lifx.BLifxNetwork#getDiscoveryPreferences
   * @see com.tridium.lifx.BLifxNetwork#setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(Flags.HIDDEN, new BLifxDeviceDiscoveryPreferences(),null);
  
  /**
   * Get the <code>discoveryPreferences</code> property.
   * @see com.tridium.lifx.BLifxNetwork#discoveryPreferences
   */
  public BNDiscoveryPreferences getDiscoveryPreferences() { return (BNDiscoveryPreferences)get(discoveryPreferences); }
  
  /**
   * Set the <code>discoveryPreferences</code> property.
   * @see com.tridium.lifx.BLifxNetwork#discoveryPreferences
   */
  public void setDiscoveryPreferences(BNDiscoveryPreferences v) { set(discoveryPreferences,v,null); }

  ////////////////////////////////////////////////////////////////
  // Action "submitDiscoveryJob"
  ////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>submitDiscoveryJob</code> action.
   * @see com.tridium.smoke.BSmokeNetwork#submitDiscoveryJob()
   */
  public static final Action submitDiscoveryJob = newAction(Flags.HIDDEN,new BLifxDeviceDiscoveryPreferences(),null);

  /**
   * Invoke the <code>submitDiscoveryJob</code> action.
   * @see com.tridium.smoke.BSmokeNetwork#submitDiscoveryJob
   */
  public BOrd submitDiscoveryJob(BNDiscoveryPreferences preferences) { return (BOrd)invoke(submitDiscoveryJob,preferences,null); }



  ////////////////////////////////////////////////////////////////
  // Type
  ////////////////////////////////////////////////////////////////
    
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
    // TODO Auto-generated method stub
    return null;
  }
  
  public BOrd doSubmitDiscoveryJob(BNDiscoveryPreferences preferences)
  {
    // Saves the most recent device discovery parameters
    setDiscoveryPreferences((BLifxDeviceDiscoveryPreferences)preferences.newCopy()); 
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