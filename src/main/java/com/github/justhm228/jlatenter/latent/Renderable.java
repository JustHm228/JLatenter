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
import java.lang.*;

/**
 * Just a stub interface with <code>{@link #render() render}()</code> method (returns <code>void</code>) which can be
 * used in {@link Latent latent typing}.
 *
 * @author JustHuman228
 * @see Shadow
 * @since 0.1-build.1
 */
@AvailableSince(value = "0.1-build.1")
@NonExtendable() // <-- Shouldn't be implemented!
@Blocking() // <-- Potentially blocking context!
@FunctionalInterface()
@Shadow() // <-- Just a stub interface
public interface Renderable {

	/**
	 * A stub method which can be called with {@link Latent latent typing}.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws LatentException If something went wrong with {@link Latent latent typing} implementation.
	 * @see Renderable
	 * @see Shadow
	 * @since 0.1-build.1
	 */
	@AvailableSince(value = "0.1-build.1")
	@NonExtendable() // <-- Shouldn't be implemented!
	@Blocking() // <-- Potentially blocking context!
	@Contract() // <-- "pure" is unknown
	@Shadow()
	// It's just a stub method:
	void render() throws Error, LatentException;
}
