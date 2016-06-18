package com.home.lifx.paremeters;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraSlots;
import javax.baja.sys.BStruct;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Created by Aaron D'souza on 6/18/2016.
 */
@NiagaraSlots(
    properties = {
        @NiagaraProperty(name = "powerLevel", type = "int", defaultValue = "0"),
        @NiagaraProperty(name = "duration", type = "long", defaultValue = "0"),
    }
)
public class BSetPowerParameters extends BStruct {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.home.lifx.paremeters.BSetPowerParameters(428437824)1.0$ @*/
/* Generated Sat Jun 18 15:32:48 IST 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "powerLevel"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code powerLevel} property.
   * @see #getPowerLevel
   * @see #setPowerLevel
   */
  public static final Property powerLevel = newProperty(0, 0, null);
  
  /**
   * Get the {@code powerLevel} property.
   * @see #powerLevel
   */
  public int getPowerLevel() { return getInt(powerLevel); }
  
  /**
   * Set the {@code powerLevel} property.
   * @see #powerLevel
   */
  public void setPowerLevel(int v) { setInt(powerLevel, v, null); }

////////////////////////////////////////////////////////////////
// Property "duration"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code duration} property.
   * @see #getDuration
   * @see #setDuration
   */
  public static final Property duration = newProperty(0, 0, null);
  
  /**
   * Get the {@code duration} property.
   * @see #duration
   */
  public long getDuration() { return getLong(duration); }
  
  /**
   * Set the {@code duration} property.
   * @see #duration
   */
  public void setDuration(long v) { setLong(duration, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSetPowerParameters.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
