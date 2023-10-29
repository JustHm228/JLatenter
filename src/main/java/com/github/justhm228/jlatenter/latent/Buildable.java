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

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@SuppressWarnings({ "suppress", "warningToken" })
public sealed interface Buildable<T extends Buildable<T>>
		permits Buildable.XBuildable, Buildable.SelfBuildable, Buildable.GenericBuildable, Buildable.SelfBuildableC,
		        Buildable.GenericBuildableC {

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<XBuildable> buildX() throws Error {

		return XBuildable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfBuildable> buildSelf() throws Error {

		return SelfBuildable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<GenericBuildable> buildGeneric() throws Error {

		return GenericBuildable.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<SelfBuildableC> buildSelfC() throws Error {

		return SelfBuildableC.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@SuppressWarnings("unused")
	static @NotNull(exception = NullPointerException.class) Class<GenericBuildableC> buildGenericC() throws Error {

		return GenericBuildableC.class;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface XBuildable extends Buildable<XBuildable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract()
		@Shadow()
		@SuppressWarnings("unused")
		void build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfBuildable extends Buildable<SelfBuildable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> this")
		@Shadow()
		@SuppressWarnings("unused")
		Object build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface GenericBuildable extends Buildable<GenericBuildable> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> this")
		@Shadow()
		@SuppressWarnings("unused")
		<T> T build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface SelfBuildableC extends Buildable<SelfBuildableC> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> _", pure = true)
		@Shadow()
		@SuppressWarnings("unused")
		Object build() throws Error, LatentException;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@FunctionalInterface()
	@Shadow()
	non-sealed interface GenericBuildableC extends Buildable<GenericBuildableC> {

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@Blocking()
		@Contract(value = " -> _", pure = true)
		@Shadow()
		@SuppressWarnings("unused")
		<T> T build() throws Error, LatentException;
	}
}
