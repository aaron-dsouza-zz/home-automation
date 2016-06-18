package com.home.lifx;

import com.home.lifx.learn.BLifxDeviceDiscoveryLeaf;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.util.SfUtil;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraSlots;
import javax.baja.sys.BFacets;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Created by Aaron D'souza on 6/18/2016.
 */
@NiagaraSlots(
        properties = {
                @NiagaraProperty(name = "macAddress", type="long", defaultValue = "0", facets = {
                        @Facet(name = BLifxDeviceDiscoveryLeaf.MGR_KEY, value = SfUtil.MGR_EDIT_READONLY)
                }),
                @NiagaraProperty(name = "ipAddress", type="BIpAddress", defaultValue = "new BIpAddress()", facets = {
                        @Facet(name = BLifxDeviceDiscoveryLeaf.MGR_KEY, value = SfUtil.MGR_EDIT_READONLY)
                })
        }
)
public class BLifxAddress extends BAddress {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.home.lifx.BLifxAddress(1566138851)1.0$ @*/
/* Generated Sat Jun 18 16:22:38 IST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
  public static final Property ipAddress = newProperty(0, new BIpAddress(), BFacets.make(BLifxDeviceDiscoveryLeaf.MGR_KEY, SfUtil.MGR_EDIT_READONLY));
  
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
  public static final Type TYPE = Sys.loadType(BLifxAddress.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public static final BIpAddress DEFAULT_IP = new BIpAddress("", 56700);
}
