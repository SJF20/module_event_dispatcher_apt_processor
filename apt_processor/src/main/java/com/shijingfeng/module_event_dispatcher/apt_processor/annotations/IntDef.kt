package com.shijingfeng.module_event_dispatcher.apt_processor.annotations

/**
 * Denotes that the annotated element of integer type, represents
 * a logical type and that its value should be one of the explicitly
 * named constants. If the IntDef#flag() attribute is set to true,
 * multiple constants can be combined.
 * <p>
 * Example:
 * <pre><code>
 *  &#64;Retention(SOURCE)
 *  &#64;IntDef({NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
 *  public @interface NavigationMode {}
 *  public static final int NAVIGATION_MODE_STANDARD = 0;
 *  public static final int NAVIGATION_MODE_LIST = 1;
 *  public static final int NAVIGATION_MODE_TABS = 2;
 *  ...
 *  public abstract void setNavigationMode(@NavigationMode int mode);
 *  &#64;NavigationMode
 *  public abstract int getNavigationMode();
 * </code></pre>
 * For a flag, set the flag attribute:
 * <pre><code>
 *  &#64;IntDef(
 *      flag = true,
 *      value = {NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
 * </code></pre>
 *
 * @see LongDef
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.ANNOTATION_CLASS)
internal annotation class IntDef(

    /** Defines the allowed constants for this element */
    vararg val value: Int = [],

    /** Defines whether the constants can be used as a flag, or just as an enum (the default) */
    val flag: Boolean = false,

    /**
     * Whether any other values are allowed. Normally this is
     * not the case, but this allows you to specify a set of
     * expected constants, which helps code completion in the IDE
     * and documentation generation and so on, but without
     * flagging compilation warnings if other values are specified.
     */
    val open: Boolean = false

)
