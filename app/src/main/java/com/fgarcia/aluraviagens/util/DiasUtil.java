package com.fgarcia.aluraviagens.util;

import android.support.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int quantidadeDeDias) {
        if(quantidadeDeDias > 1) {
          return  quantidadeDeDias + PLURAL;
        }

        return  quantidadeDeDias + SINGULAR;
    }
}
