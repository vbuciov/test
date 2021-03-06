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
public abstract class PrimaryKeyByIdPersona extends Entidad
{
    private int[] idPersona;

    //----------------------------------------------------------------------
    public PrimaryKeyByIdPersona()
    {
        idPersona = new int[Entidad.Atributo.values().length];
        Entidad.initializeIntegerPK(idPersona);
    }

    //----------------------------------------------------------------------
    public int getIdPersona()
    {
        return idPersona[Entidad.Atributo.Actual.ordinal()];
    }

    //---------------------------------------------------------------------
    public int getIdPersona(Entidad.Atributo tipo)
    {
        switch (tipo)
        {
            case Viejo:
                if (isModified())
                    return idPersona[Entidad.Atributo.Viejo.ordinal()];
            default:
                return idPersona[Entidad.Atributo.Actual.ordinal()];
        }
    }

    //---------------------------------------------------------------------
    public int getIdPersona_Viejo()
    {
        if (isModified())
            return idPersona[Entidad.Atributo.Viejo.ordinal()] != EMPTY_INT
                    ? idPersona[Entidad.Atributo.Viejo.ordinal()] : idPersona[Entidad.Atributo.Actual.ordinal()];
        else
            return idPersona[Entidad.Atributo.Actual.ordinal()];
    }

    //---------------------------------------------------------------------
    public void setIdPersona(int value)
    {
        if (isWaiting())
            idPersona[Entidad.Atributo.Viejo.ordinal()] = idPersona[Entidad.Atributo.Actual.ordinal()];

        idPersona[Entidad.Atributo.Actual.ordinal()] = value;
    }

    //---------------------------------------------------------------------
    protected void assign(PrimaryKeyByIdPersona that)
    {
         setIdPersona(that.getIdPersona());
    }
}
