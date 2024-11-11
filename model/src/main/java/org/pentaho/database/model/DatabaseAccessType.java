/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2028-08-13
 ******************************************************************************/


package org.pentaho.database.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DatabaseAccessType {

  NATIVE( "Native (JDBC)" ), ODBC( "ODBC" ), OCI( "OCI" ), PLUGIN( "Plugin specific access method" ), JNDI( "JNDI" ), CUSTOM(
      "Custom" );

  private String name;

  private static Map<String, DatabaseAccessType> typeByName = null;

  private DatabaseAccessType( String name ) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return this.toString();
  }

  public static DatabaseAccessType getAccessTypeByName( String name ) {
    if ( typeByName == null ) {
      typeByName = new HashMap<String, DatabaseAccessType>();
      for ( DatabaseAccessType type : values() ) {
        typeByName.put( type.getName(), type );
      }
    }
    return typeByName.get( name );
  }

  public static List<DatabaseAccessType> getList( DatabaseAccessType... accessTypes ) {
    ArrayList<DatabaseAccessType> list = new ArrayList<DatabaseAccessType>();
    for ( DatabaseAccessType accessType : accessTypes ) {
      list.add( accessType );
    }
    return list;
  }
}
