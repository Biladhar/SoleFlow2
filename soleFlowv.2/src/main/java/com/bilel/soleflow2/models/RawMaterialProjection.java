package com.bilel.soleflow2.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "refRm", types = {RawMaterial.class})
public interface RawMaterialProjection {
    public String getReferenceRm();

}
