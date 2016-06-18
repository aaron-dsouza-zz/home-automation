/**
 * Copyright 2013 - All Rights Reserved.
 */
package com.home.lifx.learn;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraSlots;
import javax.baja.registry.TypeInfo;
import javax.baja.sys.*;

import com.home.lifx.BLifxAddress;
import com.home.lifx.BLifxDevice;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.discover.BNDiscoveryLeaf;
import com.tridium.ndriver.util.SfUtil;


/**
 * BLifxDeviceDiscoveryLeaf is container class for Device elements to display in 
 * Device discovery pane and pass to new Device callback.
 *
 * @author Aaron D'souza
 * @creation 05-Jun-16 
 */
@NiagaraSlots(
        properties = {
                @NiagaraProperty(name = "deviceType", type="String", defaultValue = "LifxBulb", facets = {
                        @Facet(name = BLifxDeviceDiscoveryLeaf.MGR_KEY, value = SfUtil.MGR_EDIT_READONLY)
                }),
                @NiagaraProperty(name = "macAddress", type="long", defaultValue = "0", facets = {
                        @Facet(name = BLifxDeviceDiscoveryLeaf.MGR_KEY, value = SfUtil.MGR_EDIT_READONLY)
                }),
                @NiagaraProperty(name = "ipAddress", type="BIpAddress", defaultValue = "BLifxAddress.DEFAULT_IP", facets = {
                        @Facet(name = BLifxDeviceDiscoveryLeaf.MGR_KEY, value = SfUtil.MGR_EDIT_READONLY)
                })
        }
)
public class BLifxDeviceDiscoveryLeaf
    extends BNDiscoveryLeaf
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.home.lifx.learn.BLifxDeviceDiscoveryLeaf(2335324286)1.0$ @*/
/* Generated Sat Jun 18 16:05:51 IST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "deviceType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code deviceType} property.
   * @see #getDeviceType
   * @see #setDeviceType
   */
  public static final Property deviceType = newProperty(0, "LifxBulb", BFacets.make(BLifxDeviceDiscoveryLeaf.MGR_KEY, SfUtil.MGR_EDIT_READONLY));
  
  /**
   * Get the {@code deviceType} property.
   * @see #deviceType
   */
  public String getDeviceType() { return getString(deviceType); }
  
  /**
   * Set the {@code deviceType} property.
   * @see #deviceType
   */
  public void setDeviceType(String v) { setString(deviceType, v, null); }

////////////////////////////////////////////////////////////////
// Property "macAddress"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code macAddress} property.
   * @see #getMacAddress
   * @see #setMacAddress
   */
  public static final Property macAddress = newProperty(0, 0, BFacets.make(BLifxDeviceDiscoveryLeaf.MGR_KEY, SfUtil.MGR_EDIT_READONLY));
  
  /**
   * Get the {@code macAddress} property.
   * @see #macAddress
   */
  public long getMacAddress() { return getLong(macAddress); }
  
  /**
   * Set the {@code macAddress} property.
   * @see #macAddress
   */
  public void setMacAddress(long v) { setLong(macAddress, v, null); }

////////////////////////////////////////////////////////////////
// Property "ipAddress"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code ipAddress} property.
   * @see #getIpAddress
   * @see #setIpAddress
   */
  public static final Property ipAddress = newProperty(0, BLifxAddress.DEFAULT_IP, BFacets.make(BLifxDeviceDiscoveryLeaf.MGR_KEY, SfUtil.MGR_EDIT_READONLY));
  
  /**
   * Get the {@code ipAddress} property.
   * @see #ipAddress
   */
  public BIpAddress getIpAddress() { return (BIpAddress)get(ipAddress); }
  
  /**
   * Set the {@code ipAddress} property.
   * @see #ipAddress
   */
  public void setIpAddress(BIpAddress v) { set(ipAddress, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLifxDeviceDiscoveryLeaf.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public static final String MGR_KEY ="Mgr";
  public BLifxDeviceDiscoveryLeaf() {}
  

  /* Called when adding new object based on this discovery leaf.   */
  public TypeInfo[] getValidDatabaseTypes()
  {
    return new TypeInfo[] { com.home.lifx.BLifxDevice.TYPE.getTypeInfo() };
  }
  
  /**
   * Override to specify the default name when adding this discovery object
   * to the station.
   */
  public String getDiscoveryName()
  {
    //
    // TODO - specify the default name for discovery entry
    //
    return "Lifx Bulb";
  }

  
  /* Called when adding new object based on this discovery leaf.   */
  public void updateTarget(BComponent target)
  {
    BLifxDevice lifxDevice = (BLifxDevice) target;
    lifxDevice.getAddress().setMacAddress(this.getMacAddress());
    lifxDevice.getAddress().setIpAddress((BIpAddress) getIpAddress().newCopy());
  }
  
  /**
   * Return true if the specified component is an existing representation
   * of this discovery object. 
   */
  public boolean isExisting(BComponent target) 
  { 
    //
    // TODO - return true if specified component represents this leaf
    //
    
    return false;
  }

  @Override
  public BIcon getIcon() {
    return BIcon.make(BOrd.make("module://lifx/rc/bulb-icon.png"));
  }
}
