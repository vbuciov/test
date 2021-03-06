/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syswave.entidades.keys;

import com.syswave.entidades.common.Entidad;
import static com.syswave.entidades.common.Entidad.EMPTY_INT;

/**
 *
 * @author victor
 */
public abstract class CompositeKeyByIdVarianteConsecutivo extends PrimaryKeyByConsecutivo
{
     private int[] idVariante;
    
    //----------------------------------------------------------------------
    public CompositeKeyByIdVarianteConsecutivo()
    {
        super();
        idVariante = new int[Atributo.values().length];
        Entidad.initializeIntegerPK(idVariante);
    }
    
    //---------------------------------------------------------------------
    public String getCompositeKey()
    {
        return String.format("%d,%d", getConsecutivo_Viejo(), getIdVariante_Viejo());
    }

    //----------------------------------------------------------------------
    public int getIdVariante()
    {
        return idVariante[Atributo.Actual.ordinal()];
    }

    //---------------------------------------------------------------------
    public int getIdVariante(Atributo tipo)
    {
        switch (tipo)
        {
            case Viejo:
                if (isModified())
                    return idVariante[Atributo.Viejo.ordinal()];
            default:
                return idVariante[Atributo.Actual.ordinal()];
        }
    }

    //---------------------------------------------------------------------
    public int getIdVariante_Viejo()
    {
        if (isModified())
            return idVariante[Atributo.Viejo.ordinal()] != EMPTY_INT
                    ? idVariante[Atributo.Viejo.ordinal()] : idVariante[Atributo.Actual.ordinal()];
        else
            return idVariante[Atributo.Actual.ordinal()];
    }

    //---------------------------------------------------------------------
    public void setIdVariante(int value)
    {
        if (isWaiting())
            idVariante[Atributo.Viejo.ordinal()] = idVariante[Atributo.Actual.ordinal()];

        idVariante[Atributo.Actual.ordinal()] = value;
    }

    //---------------------------------------------------------------------
    protected void assign(CompositeKeyByIdVarianteConsecutivo that)
    {
        super.assign(that);
        setIdVariante(that.getIdVariante());
    }   
}
