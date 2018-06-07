package com.longshihan.ktarms.utils

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

        fun checkState(expression: Boolean){
            if (!expression){
                throw IllegalAccessException()
            }
        }

        fun checkState(expression: Boolean,errorMessage: Any?){
            if (!expression){
                throw IllegalAccessException(errorMessage.toString())
            }
        }

        fun checkState(expression: Boolean, errorMessageTemplate: String?, vararg errorMessageArgs: Any) {
            if (!expression) {
                throw IllegalArgumentException(format(errorMessageTemplate, *errorMessageArgs))
            }
        }

        fun <T> checkNotNull(refrence:T):T{
            return if (refrence==null){
                throw NullPointerException()
            }else{
                refrence
            }
        }

        fun <T> checkNotNull(reference: T?, errorMessage: Any?): T {
            return reference ?: throw java.lang.NullPointerException(errorMessage.toString())
        }

        fun <T> checkNotNull(reference: T?, errorMessageTemplate: String?, vararg errorMessageArgs: Any): T {
            return reference ?: throw java.lang.NullPointerException(format(errorMessageTemplate, *errorMessageArgs))
        }

        fun checkElementIndex(index:Int,size:Int,desc:String?="index"):Int{
            return if (index in 0..(size - 1)){
                 index
            }else{
                throw IndexOutOfBoundsException()
            }
        }


        fun badElementIndex(index:Int,size: Int,desc: String):String{
            return when {
                index<0 -> format("%s (%s) must not be negative", *arrayOf<Any>(desc, Integer.valueOf(index)))
                size < 0 -> throw java.lang.IllegalArgumentException(java.lang.StringBuilder(26).append("negative size: ").append(size).toString())
                else -> format("%s (%s) must be less than size (%s)", *arrayOf<Any>(desc, Integer.valueOf(index), Integer.valueOf(size)))
            }
        }

        @JvmOverloads
        fun checkPositionIndex(index: Int, size: Int, desc: String? = "index"): Int {
            return if (index in 0..size) {
                index
            } else {
                throw java.lang.IndexOutOfBoundsException(badPositionIndex(index, size, desc!!))
            }
        }

        private fun badPositionIndex(index: Int, size: Int, desc: String): String {
            return when {
                index < 0 -> format("%s (%s) must not be negative", *arrayOf<Any>(desc, Integer.valueOf(index)))
                size < 0 -> throw java.lang.IllegalArgumentException(java.lang.StringBuilder(26).append("negative size: ").append(size).toString())
                else -> format("%s (%s) must not be greater than size (%s)", *arrayOf<Any>(desc, Integer.valueOf(index), Integer.valueOf(size)))
            }
        }

        fun checkPositionIndexes(start: Int, end: Int, size: Int) {
            if (start < 0 || end < start || end > size) {
                throw java.lang.IndexOutOfBoundsException(badPositionIndexes(start, end, size))
            }
        }

        private fun badPositionIndexes(start: Int, end: Int, size: Int): String {
            return if (start in 0..size) if (end in 0..size) format("end index (%s) must not be less than start index (%s)", *arrayOf<Any>(Integer.valueOf(end), Integer.valueOf(start))) else badPositionIndex(end, size, "end index") else badPositionIndex(start, size, "start index")
        }

        internal fun format(template: String?, vararg args: Any): String{
            var template = template
            template = template.toString()
            val builder = StringBuilder(template.length + 16 * args.size)
            var templateStart = 0

            var i: Int = 0
            var placeholderStart: Int
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