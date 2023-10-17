/*
 * The MIT License
 *
 * Copyright (c) 2023 Chirkunov Egor
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Just a decorative annotation which should be used to mark all stub interfaces/methods used in
 * {@link Latent latent typing}.
 *
 * @author JustHuman228
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
