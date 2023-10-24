module jlatenter.test {

	requires java.base;
	requires jlatenter.base;
	requires junit;
	requires static org.jetbrains.annotations;

	exports com.github.justhm228.jlatenter.test to jlatenter.base, junit;

	opens com.github.justhm228.jlatenter.test to jlatenter.base, junit;
}
