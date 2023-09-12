package com.github.justhm228.jlatenter.latent;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

/**
 * Just a stub interface with <code>{@link #pause() pause}()</code> method (returns <code>void</code>) which can be used in {@link Latent latent typing}.
 *
 * @author JustHuman228
 * @apiNote _
 * @implSpec _
 * @implNote _
 * @see Shadow
 * @since 0.1-build.1
 */
@AvailableSince(value = "0.1-build.1")
@NonExtendable() // <-- Shouldn't be implemented!
@Blocking() // <-- Potentially blocking context!
@FunctionalInterface()
@Shadow() // <-- Just a stub interface
public interface Pausable {

	/**
	 * A stub method which can be called with {@link Latent latent typing}.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws LatentException If something went wrong with {@link Latent latent typing} implementation.
	 *
	 * @apiNote _
	 * @implSpec _
	 * @implNote _
	 *
	 * @since 0.1-build.1
	 *
	 * @see Pausable
	 * @see Shadow
	 */
	@AvailableSince(value = "0.1-build.1")
	@NonExtendable() // <-- Shouldn't be implemented!
	@Blocking() // <-- Potentially blocking context!
	@Contract() // <-- "pure" is unknown
	@Shadow()
	// <-- Just a stub method
	void pause() throws Error, LatentException;
}
