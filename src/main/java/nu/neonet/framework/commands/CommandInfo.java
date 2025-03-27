package nu.neonet.framework.commands;

public @interface CommandInfo {
    String name();
    String description() default "";
    String permission() default "";
}
