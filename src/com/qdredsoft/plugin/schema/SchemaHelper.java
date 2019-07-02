package com.qdredsoft.plugin.schema;

import com.qdredsoft.plugin.schema.base.ItemJsonSchema;
import com.qdredsoft.plugin.schema.base.SchemaType;

public final class SchemaHelper {

    public static ItemJsonSchema parse(SchemaType type) {
        switch (type) {
            case integer:
                return new NumberSchema();
            case number:
                return new IntegerSchema();
            case string:
                return new StringSchema();
            case object:
                return new ObjectSchema();
            case array:
                return new ArraySchema();
            case bool:
                return new BooleanSchema();
            default:
                return new StringSchema();
        }
    }
}
