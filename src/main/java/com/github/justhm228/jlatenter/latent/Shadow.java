package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Just a decorative annotation which should be used to mark all stub interfaces/methods used in {@link Latent latent typing}.
 *
 * @author JustHuman228
 * @apiNote _
 * @implSpec _
 * @implNote _
 * @see Startable
 * @see Stoppable
 * @see Pausable
 * @see Formattable
 * @see Formattable.SelfPrintable
 * @see Formattable.XPrintable
 * @see Formattable.SelfPrintableLN
 * @see Formattable.XPrintableLN
 * @see Formattable.SelfFormattable
 * @see Formattable.SelfFormatted
 * @see Formattable.SelfPrintableF
 * @see Formattable.XFormattable
 * @see Formattable.XPrintableF
 * @see Buildable
 * @see Buildable.XBuildable
 * @see Buildable.SelfBuildable
 * @see Buildable.GenericBuildable
 * @see Buildable.SelfBuildableC
 * @see Buildable.GenericBuildableC
 * @see Renderable
 * @see Drawable
 * @see Paintable
 * @see Steppable
 * @see Gettable
 * @see Puttable
 * @since 0.1-build.1
 */
@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@NonBlocking()
@Target(value = { TYPE, METHOD })
@Retention(value = RUNTIME)
@Documented()
public @interface Shadow {

}
