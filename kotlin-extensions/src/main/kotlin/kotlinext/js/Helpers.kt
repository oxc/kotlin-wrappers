package kotlinext.js

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Any> jsObject(): T =
    js("({})")

inline fun <T : Any> jsObject(builder: T.() -> Unit): T =
    jsObject<T>().apply(builder)

inline fun js(builder: dynamic.() -> Unit): dynamic = jsObject(builder)

fun <T : Any> clone(obj: T) = Object.assign(jsObject(), obj)

inline fun <T : Any> assign(obj: T, builder: T.() -> Unit) = clone(obj).apply(builder)

@Deprecated(
    message = "Use Object.assign instead",
    replaceWith = ReplaceWith("Object.assign(dest, src)", "kotlinext.js")
)
fun <T, R : T> assign(dest: R, src: T): R = Object.assign(dest, src)

fun toPlainObjectStripNull(obj: Any) = js {
    for (key in Object.keys(obj)) {
        val value = obj.asDynamic()[key]
        if (value != null) this[key] = value
    }
}
