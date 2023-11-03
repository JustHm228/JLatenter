/**
 * Stores all the unit tests of the JLatenter library.
 *
 * <p>
 * This module is considered internal, so the user can't and shouldn't access anything in this module, including
 * Javadocs. All the Javadocs here provided only and only because why not, and not included in the global
 * documentation.
 * </p>
 *
 * <p>
 * <b>
 * Note: This module also uses <code>org.jetbrains:annotations:24.0.1</code>'s annotations to enable a better static
 * analysis, but it isn't required, so if you don't provide the dependency yourself, then all annotations will be
 * ignored, and if you provide it - your IDE should enable better static analysis automatically.
 * </b>
 * </p>
 *
 * @since 0.1-build.2
 */
module jlatenter.test {

	requires java.base;
	requires jlatenter.base;
	requires junit;
	requires static org.jetbrains.annotations;

	exports com.github.justhm228.jlatenter.test to jlatenter.base, junit;

	opens com.github.justhm228.jlatenter.test to jlatenter.base, junit;
}
