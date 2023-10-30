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
 * @see com.github.justhm228.jlatenter.latent.stub.Renderable
 * @since 0.1-build.1
 * @deprecated Due to an error made when planning the project structure, the final structure didn't take into
 * account that there could be more than one or several dozen {@link Shadow stub} interfaces, despite the fact that
 * they're all stored in a package designed specifically for the "general" implementation (not for "extended"). This
 * error could lead to the fact that, in the future, there'll be more classes in the
 * {@link com.github.justhm228.jlatenter.latent "general" package} alone than in the others (the approximate number
 * is estimated at 40-50 or more). This is a problem because 1.) it contradicts the original concept of packages in
 * the Java programming language, and 2.) it contradicts the original basis for which these particular classes were
 * combined into {@link com.github.justhm228.jlatenter.latent this particular package}. And in order to solve this
 * problem it was decided to move all {@link Shadow stub} interfaces from the
 * {@link com.github.justhm228.jlatenter.latent "general" package} to a specially created
 * {@link com.github.justhm228.jlatenter.latent.stub stub} subpackage. But in order to maintain backward
 * compatibility, it was decided not to move all the classes in the usual sense of the word, but simply copy them
 * there and inherit them from the previous ones, and mark the previous ones as {@link Deprecated deprecated}.
 * Further use of these {@link Deprecated deprecated} classes in newer code is highly discouraged, because
 * maintaining backward compatibility with one single pre-release 0.1-build.1 isn't such a priority, which means
 * that in one of the future releases these classes can be removed at any time, but this isn't yet guaranteed.
 */
@AvailableSince("0.1-build.1")
@NonExtendable() // <-- Shouldn't be implemented!
@Blocking() // <-- Potentially blocking context!
@FunctionalInterface()
@Shadow() // <-- Just a stub interface
@Deprecated(since = "0.1-build.2")
@SuppressWarnings({ "suppress", "warningToken" })
public interface Renderable {

	/**
	 * A stub method which can be called with {@link Latent latent typing}.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws LatentException If something went wrong with {@link Latent latent typing} implementation.
	 * @see Renderable
	 * @see Shadow
	 * @see com.github.justhm228.jlatenter.latent.stub.Renderable
	 * @see com.github.justhm228.jlatenter.latent.stub.Renderable#render()
	 * @since 0.1-build.1
	 * @deprecated Due to an error made when planning the project structure, the final structure didn't take into
	 * account that there could be more than one or several dozen {@link Shadow stub} interfaces, despite the fact that
	 * they're all stored in a package designed specifically for the "general" implementation (not for "extended"). This
	 * error could lead to the fact that, in the future, there'll be more classes in the
	 * {@link com.github.justhm228.jlatenter.latent "general" package} alone than in the others (the approximate number
	 * is estimated at 40-50 or more). This is a problem because 1.) it contradicts the original concept of packages in
	 * the Java programming language, and 2.) it contradicts the original basis for which these particular classes were
	 * combined into {@link com.github.justhm228.jlatenter.latent this particular package}. And in order to solve this
	 * problem it was decided to move all {@link Shadow stub} interfaces from the
	 * {@link com.github.justhm228.jlatenter.latent "general" package} to a specially created
	 * {@link com.github.justhm228.jlatenter.latent.stub stub} subpackage. But in order to maintain backward
	 * compatibility, it was decided not to move all the classes in the usual sense of the word, but simply copy them
	 * there and inherit them from the previous ones, and mark the previous ones as {@link Deprecated deprecated}.
	 * Further use of these {@link Deprecated deprecated} classes in newer code is highly discouraged, because
	 * maintaining backward compatibility with one single pre-release 0.1-build.1 isn't such a priority, which means
	 * that in one of the future releases these classes can be removed at any time, but this isn't yet guaranteed.
	 */
	@AvailableSince("0.1-build.1")
	@NonExtendable() // <-- Shouldn't be implemented!
	@Blocking() // <-- Potentially blocking context!
	@Contract() // <-- "pure" is unknown
	@Shadow() // It's just a stub method
	@Deprecated(since = "0.1-build.2")
	void render() throws Error, LatentException;
}
