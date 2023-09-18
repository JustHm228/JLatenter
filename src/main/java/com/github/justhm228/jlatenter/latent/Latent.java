/*
 * Copyright (c) 2023 JustHuman228
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

import static java.lang.Integer.*;
import static java.lang.System.*;
import java.lang.reflect.*;
import static java.lang.reflect.Proxy.*;
import java.security.*;
import java.util.*;
import static java.util.Objects.requireNonNull;
import static java.util.Objects.hash;
import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@NonBlocking()
public final class Latent {

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	private Latent() throws Error, UnsupportedOperationException {

		super();

		throw new UnsupportedOperationException(

				"An instance of this type (" +
						getClass().getTypeName() +
				") can't be instantiated with a constructor!"
		);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	public static @NotNull(exception = NullPointerException.class) Object as(
			@NotNull(value = "The specified latent instance is null!") final Object instance,
			@NotNull(value = "The specified cast type is null!", exception = NullPointerException.class) final Object type
	) throws Error, NullPointerException, IllegalArgumentException {

		requireNonNull(instance, "The specified latent instance is null!");
		requireNonNull(type, "The specified cast type is null!");

		@NotNull(exception = NullPointerException.class)
		final Class<?> @NotNull(exception = NullPointerException.class) [] latents =
				type.getClass().getInterfaces();

		final int length = latents.length;

		if (length != 1) {

			throw new IllegalArgumentException(

					"The number of latents (" +
							length +
					") in the specified cast type (" +
							type +
					") isn't equal 1!"
			);
		}

		return as(instance, latents[0]);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	public static <T> @NotNull(exception = NullPointerException.class) T as(
			@NotNull(value = "The specified latent instance is null!", exception = NullPointerException.class) final Object instance,
			@NotNull(value = "The specified cast type is null!", exception = NullPointerException.class) final Class<T> type
	) throws Error, NullPointerException, IllegalArgumentException {

		requireNonNull(instance, "The specified latent instance is null!");
		requireNonNull(type, "The specified cast type is null!");

		if (!type.isInterface()) {

			throw new IllegalArgumentException(

					"The specified cast type (" +
							type.getTypeName() +
					") isn't an interface!"
			);
		}

		@NotNull(exception = NullPointerException.class)
		@SuppressWarnings(value = { "unchecked" })
		final T proxy = (T) newProxyInstance(

				type.getClassLoader(),
				new Class[] { type },
				new LatentHandler(instance)
		);

		return proxy;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	public static boolean isShadowed(@Nullable(value = "Can be null anytime") final Object instance) throws Error {

		if (instance == null) {

			return false;
		}

		if (isProxyClass(instance.getClass())) {

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings(value = { "removal" })
			final InvocationHandler handler = AccessController.doPrivileged(

					(PrivilegedAction<? extends InvocationHandler>) () -> getInvocationHandler(instance),
					AccessController.getContext(),
					new RuntimePermission("accessClassInPackage.*")
			);

			return handler instanceof LatentHandler;
		}

		return false;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	public static <T> @UnknownNullability(value = "Will be null if the specified proxy instance isn't a shadowed latent instance") T find(
			@NotNull(value = "The specified proxy instance is null!", exception = NullPointerException.class) final Object proxy,
			@Nullable(value = "Can be null anytime") @SuppressWarnings(value = { "unused" }) final Class<T> cast
	) throws Error, NullPointerException, ClassCastException {

		@UnknownNullability(value = "Will be null if the specified proxy instance isn't a shadowed latent instance")
		@SuppressWarnings(value = { "unchecked" })
		final T instance = (T) find(

				requireNonNull(proxy, "The specified proxy instance is null!")
		);

		return instance;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	public static @UnknownNullability(value = "Will be null if the specified proxy instance isn't a shadowed latent instance") Object find(
			@NotNull(value = "The specified proxy instance is null!", exception = NullPointerException.class) final Object proxy
	) throws Error, NullPointerException {

		requireNonNull(proxy, "The specified proxy instance is null!");

		if (isProxyClass(proxy.getClass())) {

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings(value = { "removal" })
			final InvocationHandler handler = AccessController.doPrivileged(

					(PrivilegedAction<? extends InvocationHandler>) () -> getInvocationHandler(proxy),
					AccessController.getContext(),
					new RuntimePermission("accessClassInPackage.*")
			);

			if (handler instanceof
					@NotNull(exception = NullPointerException.class) final LatentHandler latent) {

				return latent.present();
			}
		}

		return null;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return getClass().getTypeName();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(
			@Nullable(value = "Can be null anytime") final Object another
	) throws Error {

		return another instanceof Latent;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return hash(getClass());
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.1")
	@Override()
	protected Latent clone() throws Error, CloneNotSupportedException {

		throw new CloneNotSupportedException(getClass().getTypeName());
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Deprecated(since = "0.1-build.1", forRemoval = true)
	@Override()
	@SuppressWarnings(value = { "removal" })
	protected void finalize() throws Throwable {

		super.finalize();
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	private record LatentHandler(

			@NotNull(exception = NullPointerException.class) Object present

	) implements InvocationHandler {

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonBlocking()
		@Contract(pure = true)
		private LatentHandler(
				@NotNull(value = "The specified latent instance is null!", exception = NullPointerException.class) final Object present
		) {

			this.present = requireNonNull(

					present,
					"The specified latent instance is null!"
			);
		}

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		@Contract(value = "_ -> new", pure = true)
		public static @NotNull(exception = NullPointerException.class) LatentHandler getInstance(
				@NotNull(value = "The specified latent instance is null!", exception = NullPointerException.class) final Object present
		) throws Error, NullPointerException {

			return new LatentHandler(present);
		}

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		@Contract(value = " -> _", pure = true)
		@Override()
		public @NotNull(exception = NullPointerException.class) Object present() {

			return present;
		}

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		@Contract(value = "_, _, _ -> _")
		@Override()
		public @Nullable(value = "Can be null anytime") Object invoke(
				@NotNull(exception = NullPointerException.class) final Object proxy,
				@NotNull(exception = NullPointerException.class) final Method method,
				@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") [] args
		) throws Error, LatentNotPresentException, IncompatibleLatentException,
				InaccessibleLatentException, LatentInitException, LatentTargetException {

			@NotNull(exception = NullPointerException.class)
			Class<?> cast = present.getClass();

			try {

				@SuppressWarnings(value = { "removal" })
				final Method called = AccessController.doPrivileged(

						(PrivilegedExceptionAction<Method>) () -> cast.getDeclaredMethod(

								method.getName(),
								method.getParameterTypes()
						),

						AccessController.getContext(),
						new RuntimePermission("accessDeclaredMembers"),
						new RuntimePermission("accessClassInPackage." + cast.getPackageName())
				);

				@NotNull(exception = NullPointerException.class)
				Class<?> result = called.getReturnType(),

						 proxied = method.getReturnType();

				if (result.isPrimitive() || proxied.isPrimitive()) {

					if (result == void.class) {

						result = Void.class;

					} else if (result == boolean.class) {

						result = Boolean.class;

					} else if (result == byte.class) {

						result = Byte.class;

					} else if (result == short.class) {

						result = Short.class;

					} else if (result == int.class) {

						result = Integer.class;

					} else if (result == long.class) {

						result = Long.class;

					} else if (result == float.class) {

						result = Float.class;

					} else if (result == double.class) {

						result = Double.class;

					} else if (result == char.class) {

						result = Character.class;
					}

					if (proxied == void.class) {

						proxied = Void.class;

					} else if (proxied == boolean.class) {

						proxied = Boolean.class;

					} else if (proxied == byte.class) {

						proxied = Byte.class;

					} else if (proxied == short.class) {

						proxied = Short.class;

					} else if (proxied == int.class) {

						proxied = Integer.class;

					} else if (proxied == long.class) {

						proxied = Long.class;

					} else if (proxied == float.class) {

						proxied = Float.class;

					} else if (proxied == double.class) {

						proxied = Double.class;

					} else if (proxied == char.class) {

						proxied = Character.class;
					}
				}

				if (proxied == Void.class || proxied.isAssignableFrom(result)) {

					if (!called.canAccess(Modifier.isStatic(called.getModifiers()) ? null : present)) {

						@NotNull(exception = NullPointerException.class)
						@SuppressWarnings(value = { "removal" })
						final Boolean accessible = AccessController.doPrivileged(

								(PrivilegedAction<Boolean>) called::trySetAccessible,
								AccessController.getContext(),
								new ReflectPermission("suppressAccessChecks")
						);

						if (!accessible) {

							throw new InaccessibleLatentException(

									"The used method (" +
											called +
									") is inaccessible!"
							);
						}
					}

					try {

						return called.invoke(present, args);

					} catch (@NotNull(exception = NullPointerException.class) final IllegalAccessException inaccessible) {

						throw new InaccessibleLatentException(

								"The used method (" +
										called +
								") is inaccessible!",
								inaccessible
						);

					} catch (@NotNull(exception = NullPointerException.class) final ExceptionInInitializerError init) {

						throw new LatentInitException(

								"The used method (" +
										called +
								") thrown an exception in initializer!",
								init.getException()
						);

					} catch (@NotNull(exception = NullPointerException.class) final InvocationTargetException invocation) {

						throw new LatentTargetException(

								"The used method (" +
										called +
								") thrown an exception!",
								invocation.getTargetException()
						);
					}
				}

				throw new IncompatibleLatentException(

						"The proxied method (" +
								method +
						") is incompatible with found (" +
								called +
						")!"
				);

			} catch (@NotNull(exception = NullPointerException.class) final PrivilegedActionException notFound) {

				// TODO: 18.09.2023 Try to get rid of this:
				if (Objects.equals(method.getDeclaringClass(), Object.class)) {

					switch (method.getName()) {

						case "toString" -> {

							if (args != null && args.length > 0) {

								throw new LatentNotPresentException(

										"The proxied method (" +
												method +
										") has no compatible latents!"
								);
							}

							return proxy.getClass().getName() +
									"@" +
									toHexString(identityHashCode(proxy));
						}

						case "equals" -> {

							if (args == null || args.length != 1) {

								throw new LatentNotPresentException(

										"The proxied method (" +
												method +
										") has no compatible latents!"
								);
							}

							return proxy == args[0];
						}

						case "hashCode" -> {

							if (args != null && args.length > 0) {

								throw new LatentNotPresentException(

										"The proxied method (" +
												method +
										") has no compatible latents!"
								);
							}

							return identityHashCode(proxy);
						}

						case "clone" -> {

							try {

								throw new CloneNotSupportedException(

										proxy.getClass().getTypeName()
								);

							} catch (final CloneNotSupportedException unsupported) {

								throw new LatentTargetException(

										"The used method (" +
												method +
										") thrown an exception!",
										unsupported
								);
							}
						}

						case "finalize" -> {

							return null;
						}
					}
				}

				if (!method.canAccess(Modifier.isStatic(method.getModifiers()) ? null : present)) {

					@NotNull(exception = NullPointerException.class)
					@SuppressWarnings(value = { "removal" })
					final Boolean accessible = AccessController.doPrivileged(

							(PrivilegedAction<Boolean>) method::trySetAccessible,
							AccessController.getContext(),
							new ReflectPermission("suppressAccessChecks")
					);

					if (!accessible) {

						throw new InaccessibleLatentException(

								"The used method (" +
										method +
								") is inaccessible!"
						);
					}
				}

				try {

					return method.invoke(present, args);

				} catch (@NotNull(exception = NullPointerException.class) final IllegalArgumentException incompatible) {

					throw new LatentNotPresentException(

							"The proxied method (" +
									method +
							") has no compatible latents!",
							incompatible
					);

				} catch (@NotNull(exception = NullPointerException.class) final IllegalAccessException inaccessible) {

					throw new InaccessibleLatentException(

							"The used method (" +
									method +
							") is inaccessible!",
							inaccessible
					);

				} catch (@NotNull(exception = NullPointerException.class) final ExceptionInInitializerError init) {

					throw new LatentInitException(

							"The used method (" +
									method +
							") thrown an exception in initializer!",
							init.getException()
					);

				} catch (@NotNull(exception = NullPointerException.class) final InvocationTargetException invocation) {

					throw new LatentTargetException(

							"The used method (" +
									method +
							") thrown an exception!",
							invocation.getTargetException()
					);
				}
			}
		}

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@NonBlocking()
		@Contract(value = " -> _", pure = true)
		@Override()
		public @NotNull(exception = NullPointerException.class) String toString() throws Error {

			return getClass().getTypeName() +
					"[present = " +
					present +
					"]";
		}

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@NonBlocking()
		@Contract(value = "null -> false; !null -> _", pure = true)
		@Override()
		public boolean equals(
				@Nullable(value = "Can be null anytime") final Object another
		) throws Error {

			return another instanceof
					final LatentHandler other &&
					present == other.present;
		}

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@NonBlocking()
		@Contract(value = " -> _", pure = true)
		@Override()
		public int hashCode() throws Error {

			return hash(identityHashCode(present));
		}
	}
}
