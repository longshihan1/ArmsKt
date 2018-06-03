package com.longshihan.ktarms.utils

import android.support.annotation.Nullable
import javax.xml.xpath.XPathExpression

/**
 * Created by LONGHE001.
 * @time 2018/6/3 0003
 * @des
 * @function
 */
class Preconditions private constructor(){
    init {
        throw IllegalStateException("you can't instantiate me!")
    }
    companion object {
        fun checkArgument(expression: Boolean){
            if (!expression){
                throw  IllegalAccessException()
            }
        }

        fun checkArgument(expression: Boolean,errorMessage: Any?){
            if (!expression){
                throw  IllegalAccessException(errorMessage.toString())
            }
        }

        fun checkArgument(expression: Boolean, errorMessageTemplate: String?, vararg errorMessageArgs: Any) {
            if (!expression) {
                throw IllegalArgumentException(format(errorMessageTemplate, *errorMessageArgs))
            }
        }


        internal fun format(template: String?, vararg args: Any): String{
            var template = template
            template = template.toString()
            val builder = StringBuilder(template.length + 16 * args.size)
            var templateStart = 0

            var i: Int
            var placeholderStart: Int
            i = 0
            while (i < args.size) {
                placeholderStart = template.indexOf("%s", templateStart)
                if (placeholderStart == -1) {
                    break
                }

                builder.append(template.substring(templateStart, placeholderStart))
                builder.append(args[i++])
                templateStart = placeholderStart + 2
            }

            builder.append(template.substring(templateStart))
            if (i < args.size) {
                builder.append(" [")
                builder.append(args[i++])

                while (i < args.size) {
                    builder.append(", ")
                    builder.append(args[i++])
                }

                builder.append(']')
            }

            return builder.toString()
        }

    }

}