/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8;

//import javax.baja.license.Feature;
import javax.baja.naming.BOrd;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.comm.http.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;
import com.tridium.spherobb8.comm.BSpheroBB8SerialCommConfig;
import com.tridium.spherobb8.comm.BSpheroBB8TcpCommConfig;
import com.tridium.spherobb8.learn.BSpheroBB8DeviceDiscoveryPreferences;



/**
 *  BSpheroBB8Network models a network of devices
 *
 *  @author   Aaron D'souza
 *  @creation 24-May-16 
 */
@NiagaraSlots(
  properties = {
    @NiagaraProperty(name = "pollScheduler", type = "BNPollScheduler",  defaultValue = "new BNPollScheduler()"),
    @NiagaraProperty(name = "httpConfig", type = "BHttpCommConfig",  defaultValue = "new BHttpCommConfig()"),
    @NiagaraProperty(name = "tcpConfig", type = "BSpheroBB8TcpCommConfig",  defaultValue = "new BSpheroBB8TcpCommConfig()"),
    @NiagaraProperty(name = "udpConfig", type = "BUdpCommConfig",  defaultValue = "new BUdpCommConfig()"),
    @NiagaraProperty(name = "serialConfig", type = "BSpheroBB8SerialCommConfig",  defaultValue = "new BSpheroBB8SerialCommConfig()"),
    @NiagaraProperty(name = "discoveryPreferences", type = "BNDiscoveryPreferences",  defaultValue = "new BSpheroBB8DeviceDiscoveryPreferences()", flags = Flags.HIDDEN),
  },
 actions = {
   @NiagaraAction(name="submitDiscoveryJob", defaultValue = "new BSpheroBB8DeviceDiscoveryPreferences()", 
                  parameterType = "BNDiscoveryPreferences", returnType = "BOrd", flags = Flags.HIDDEN)
 }  

)
public class BSpheroBB8Network 
  extends BNNetwork
  implements BINDiscoveryHost
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
  
////////////////////////////////////////////////////////////////
//Property "pollScheduler"
////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>pollScheduler</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#getPollScheduler
     * @see com.tridium.spherobb8.BSpheroBB8Network#setPollScheduler
     */
    public static final Property pollScheduler = newProperty(0, new BNPollScheduler(),null);
    
    /**
     * Get the <code>pollScheduler</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#pollScheduler
     */
    public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }
    
    /**
     * Set the <code>pollScheduler</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#pollScheduler
     */
    public void setPollScheduler(BNPollScheduler v) { set(pollScheduler,v,null); }

  
  ////////////////////////////////////////////////////////////////
  // Property "httpConfig"
  ////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>httpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#getHttpConfig
     * @see com.tridium.spherobb8.BSpheroBB8Network#setHttpConfig
     */
    public static final Property httpConfig = newProperty(0, new BHttpCommConfig(),null);
    
    /**
     * Get the <code>httpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#httpConfig
     */
    public BHttpCommConfig getHttpConfig() { return (BHttpCommConfig)get(httpConfig); }
    
    /**
     * Set the <code>httpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#httpConfig
     */
    public void setHttpConfig(BHttpCommConfig v) { set(httpConfig,v,null); }
  
  
  ////////////////////////////////////////////////////////////////
  // Property "tcpConfig"
  ////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>tcpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#getTcpConfig
     * @see com.tridium.spherobb8.BSpheroBB8Network#setTcpConfig
     */
    public static final Property tcpConfig = newProperty(0, new BTcpCommConfig(),null);
    
    /**
     * Get the <code>tcpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#tcpConfig
     */
    public BTcpCommConfig getTcpConfig() { return (BTcpCommConfig)get(tcpConfig); }
    
    /**
     * Set the <code>tcpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#tcpConfig
     */
    public void setTcpConfig(BTcpCommConfig v) { set(tcpConfig,v,null); }

  ////////////////////////////////////////////////////////////////
  // Property "udpConfig"
  ////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>udpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#getUdpConfig
     * @see com.tridium.spherobb8.BSpheroBB8Network#setUdpConfig
     */
    public static final Property udpConfig = newProperty(0, new BUdpCommConfig(),null);
    
    /**
     * Get the <code>udpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#udpConfig
     */
    public BUdpCommConfig getUdpConfig() { return (BUdpCommConfig)get(udpConfig); }
    
    /**
     * Set the <code>udpConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#udpConfig
     */
    public void setUdpConfig(BUdpCommConfig v) { set(udpConfig,v,null); }

  ////////////////////////////////////////////////////////////////
  // Property "serialConfig"
  ////////////////////////////////////////////////////////////////
    
    /**
     * Slot for the <code>serialConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#getSerialConfig
     * @see com.tridium.spherobb8.BSpheroBB8Network#setSerialConfig
     */
    public static final Property serialConfig = newProperty(0, new BSpheroBB8SerialCommConfig(),null);
    
    /**
     * Get the <code>serialConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#serialConfig
     */
    public BSpheroBB8SerialCommConfig getSerialConfig() { return (BSpheroBB8SerialCommConfig)get(serialConfig); }
    
    /**
     * Set the <code>serialConfig</code> property.
     * @see com.tridium.spherobb8.BSpheroBB8Network#serialConfig
     */
    public void setSerialConfig(BSpheroBB8SerialCommConfig v) { set(serialConfig,v,null); }
  
  ////////////////////////////////////////////////////////////////
  // Property "discoveryPreferences"
  ////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>discoveryPreferences</code> property.
   * @see com.tridium.spherobb8.BSpheroBB8Network#getDiscoveryPreferences
   * @see com.tridium.spherobb8.BSpheroBB8Network#setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(Flags.HIDDEN, new BSpheroBB8DeviceDiscoveryPreferences(),null);
  
  /**
   * Get the <code>discoveryPreferences</code> property.
   * @see com.tridium.spherobb8.BSpheroBB8Network#discoveryPreferences
   */
  public BNDiscoveryPreferences getDiscoveryPreferences() { return (BNDiscoveryPreferences)get(discoveryPreferences); }
  
  /**
   * Set the <code>discoveryPreferences</code> property.
   * @see com.tridium.spherobb8.BSpheroBB8Network#discoveryPreferences
   */
  public void setDiscoveryPreferences(BNDiscoveryPreferences v) { set(discoveryPreferences,v,null); }

  ////////////////////////////////////////////////////////////////
  // Action "submitDiscoveryJob"
  ////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>submitDiscoveryJob</code> action.
   * @see com.tridium.smoke.BSmokeNetwork#submitDiscoveryJob()
   */
  public static final Action submitDiscoveryJob = newAction(Flags.HIDDEN,new BSpheroBB8DeviceDiscoveryPreferences(),null);

  /**
   * Invoke the <code>submitDiscoveryJob</code> action.
   * @see com.tridium.smoke.BSmokeNetwork#submitDiscoveryJob
   */
  public BOrd submitDiscoveryJob(BNDiscoveryPreferences preferences) { return (BOrd)invoke(submitDiscoveryJob,preferences,null); }



  ////////////////////////////////////////////////////////////////
  // Type
  ////////////////////////////////////////////////////////////////
    
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroBB8Network.class);

  /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
  
   

  /** Specify name for network resources. */
  public String getNetworkName() { return "SpheroBB8Network"; }

  /** return device folder type  */
  @Override
  public Type getDeviceFolderType()
  {
    return BSpheroBB8DeviceFolder.TYPE;
  }

  /** return device type */
  @Override
  public Type getDeviceType()
  {
    return BSpheroBB8Device.TYPE;
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
      getHttpConfig().statusUpdate();
      getTcpConfig().statusUpdate();
      getUdpConfig().statusUpdate();
      getSerialConfig().statusUpdate();
  
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
    setDiscoveryPreferences((BSpheroBB8DeviceDiscoveryPreferences)preferences.newCopy()); 
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
  
  /** Access the http comm stack */
  public HttpComm hcomm() 
  {
    return (HttpComm)getHttpConfig().comm();
  }
  
  /**Access the tcp comm stack */
  public NComm tcomm()
  {
    return (NComm)getTcpConfig().comm();
  }
  
   /** Access the udp comm stack */
  public NComm ucomm() 
  {
    return (NComm)getUdpConfig().comm();
  }
  
   /**Access the serial comm stack */
  public NComm scomm()
  {
    return (NComm)getSerialConfig().comm();
  }
  
  
  public static Lexicon LEX = Lexicon.make(BSpheroBB8Network.class);

}
