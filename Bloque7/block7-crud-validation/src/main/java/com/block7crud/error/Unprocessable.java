package com.block7crud.error;

public class Unprocessable extends IllegalArgumentException {

        private static final long serialVersionUID = -3946078288741435789L;

        public Unprocessable( String message) {
            super(message);
        }

}
