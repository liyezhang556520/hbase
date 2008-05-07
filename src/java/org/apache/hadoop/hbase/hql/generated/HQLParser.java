/* Generated By:JavaCC: Do not edit this line. HQLParser.java */
package org.apache.hadoop.hbase.hql.generated;

/**
 * Copyright 2007 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.StringReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

import org.apache.hadoop.hbase.hql.*;

/**
 * Parsing command line.
 */
public class HQLParser implements HQLParserConstants {
  private String QueryString;
  private TableFormatter formatter;
  private Writer out;

  public HQLParser(final String query, final Writer o, final TableFormatter f) {
    this((Reader)(new StringReader(query)));
    this.QueryString = query;
    this.formatter = f;
    this.out = o;
  }

  public String getQueryStr() {
    return this.QueryString;
  }

/**
 * Parses the given array of command line arguments.
 */
  final public Command terminatedCommand() throws ParseException {
    Command statement = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case HELP:
    case ALTER:
    case CLEAR:
    case SHOW:
    case DESCRIBE:
    case DESC:
    case CREATE:
    case DROP:
    case TRUNCATE:
    case FS:
    case JAR:
    case EXIT:
    case INSERT:
    case DELETE:
    case SELECT:
    case ENABLE:
    case DISABLE:
    case 70:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case HELP:
      case ALTER:
      case CLEAR:
      case SHOW:
      case DESCRIBE:
      case DESC:
      case CREATE:
      case DROP:
      case TRUNCATE:
      case FS:
      case JAR:
      case EXIT:
      case INSERT:
      case DELETE:
      case SELECT:
      case ENABLE:
      case DISABLE:
        statement = cmdStatement();
        break;
      default:
        jj_la1[0] = jj_gen;
        ;
      }
      jj_consume_token(70);
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        {if (true) return statement;}
    throw new Error("Missing return statement in function");
  }

  final public Command cmdStatement() throws ParseException {
    Command cmd = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EXIT:
      cmd = exitCommand();
      break;
    case HELP:
      cmd = helpCommand();
      break;
    case SHOW:
      cmd = showCommand();
      break;
    case DESCRIBE:
    case DESC:
      cmd = descCommand();
      break;
    case CREATE:
      cmd = createCommand();
      break;
    case DROP:
      cmd = dropCommand();
      break;
    case TRUNCATE:
      cmd = truncateCommand();
      break;
    case ALTER:
      cmd = alterCommand();
      break;
    case INSERT:
      cmd = insertCommand();
      break;
    case DELETE:
      cmd = deleteCommand();
      break;
    case SELECT:
      cmd = selectCommand();
      break;
    case ENABLE:
      cmd = enableCommand();
      break;
    case DISABLE:
      cmd = disableCommand();
      break;
    case CLEAR:
      cmd = clearCommand();
      break;
    case FS:
      cmd = fsCommand();
      break;
    case JAR:
      cmd = jarCommand();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
       {if (true) return cmd;}
    throw new Error("Missing return statement in function");
  }

  final public ExitCommand exitCommand() throws ParseException {
  ExitCommand exit = new ExitCommand(this.out);
    jj_consume_token(EXIT);
             {if (true) return exit;}
    throw new Error("Missing return statement in function");
  }

  final public FsCommand fsCommand() throws ParseException {
  Token t = null;
  FsCommand fs = new FsCommand(this.out);
  List<String> query = new ArrayList<String>();
    jj_consume_token(FS);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      t = jj_consume_token(ID);
        query.add(t.image.toString());
    }
    fs.setQuery(query);
    {if (true) return fs;}
    throw new Error("Missing return statement in function");
  }

  final public JarCommand jarCommand() throws ParseException {
  Token t = null;
  JarCommand jar = new JarCommand(this.out);
  List<String> query = new ArrayList<String>();
    jj_consume_token(JAR);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        t = jj_consume_token(ID);
        break;
      case INTEGER_LITERAL:
        t = jj_consume_token(INTEGER_LITERAL);
        break;
      case FLOATING_POINT_LITERAL:
        t = jj_consume_token(FLOATING_POINT_LITERAL);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        query.add(t.image.toString());
    }
    jar.setQuery(query);
    {if (true) return jar;}
    throw new Error("Missing return statement in function");
  }

  final public TruncateCommand truncateCommand() throws ParseException {
  TruncateCommand truncate = new TruncateCommand(this.out);
  String tableName = null;
    jj_consume_token(TRUNCATE);
    jj_consume_token(TABLE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
    case QUOTED_IDENTIFIER:
    case STRING_LITERAL:
      tableName = identifier();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    truncate.setTableName(tableName);
    {if (true) return truncate;}
    throw new Error("Missing return statement in function");
  }

  final public HelpCommand helpCommand() throws ParseException {
  Token t = null;
  HelpCommand help = new HelpCommand(this.out, this.formatter);
  String argument = "";
    jj_consume_token(HELP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ALTER:
    case CLEAR:
    case SHOW:
    case DESCRIBE:
    case CREATE:
    case DROP:
    case FS:
    case JAR:
    case EXIT:
    case INSERT:
    case DELETE:
    case SELECT:
    case ID:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SHOW:
        t = jj_consume_token(SHOW);
        break;
      case DESCRIBE:
        t = jj_consume_token(DESCRIBE);
        break;
      case CREATE:
        t = jj_consume_token(CREATE);
        break;
      case DROP:
        t = jj_consume_token(DROP);
        break;
      case EXIT:
        t = jj_consume_token(EXIT);
        break;
      case INSERT:
        t = jj_consume_token(INSERT);
        break;
      case DELETE:
        t = jj_consume_token(DELETE);
        break;
      case SELECT:
        t = jj_consume_token(SELECT);
        break;
      case ALTER:
        t = jj_consume_token(ALTER);
        break;
      case CLEAR:
        t = jj_consume_token(CLEAR);
        break;
      case FS:
        t = jj_consume_token(FS);
        break;
      case JAR:
        t = jj_consume_token(JAR);
        break;
      case ID:
        t = jj_consume_token(ID);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
         argument = t.image.toString();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
      help.setArgument(argument);
      {if (true) return help;}
    throw new Error("Missing return statement in function");
  }

  final public ShowCommand showCommand() throws ParseException {
  ShowCommand show = new ShowCommand(this.out, this.formatter);
  String argument = null;
    jj_consume_token(SHOW);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
    case QUOTED_IDENTIFIER:
    case STRING_LITERAL:
      argument = identifier();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
      show.setArgument(argument);
      {if (true) return show;}
    throw new Error("Missing return statement in function");
  }

  final public DescCommand descCommand() throws ParseException {
  DescCommand desc = new DescCommand(this.out, this.formatter);
  String argument = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DESCRIBE:
      jj_consume_token(DESCRIBE);
      break;
    case DESC:
      jj_consume_token(DESC);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    argument = identifier();
    desc.setArgument(argument);
    {if (true) return desc;}
    throw new Error("Missing return statement in function");
  }

  final public Map<String, Object> ColumnSpec() throws ParseException {
  Map<String, Object> columnSpec = new HashMap<String, Object>();
  int n = -1;
  Token t = null;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAX_VERSIONS:
      case MAX_LENGTH:
      case COMPRESSION:
      case IN_MEMORY:
      case BLOCK_CACHE_ENABLED:
      case TTL:
      case BLOOMFILTER:
      case VECTOR_SIZE:
      case NUM_HASH:
      case NUM_ENTRIES:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAX_VERSIONS:
        jj_consume_token(MAX_VERSIONS);
        jj_consume_token(EQUALS);
        n = number();
       if(n < 0) {
         n = Integer.MAX_VALUE;
       }
      columnSpec.put("MAX_VERSIONS", n);
        break;
      case MAX_LENGTH:
        jj_consume_token(MAX_LENGTH);
        jj_consume_token(EQUALS);
        n = number();
      columnSpec.put("MAX_LENGTH", n);
        break;
      case COMPRESSION:
        jj_consume_token(COMPRESSION);
        jj_consume_token(EQUALS);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NONE:
          t = jj_consume_token(NONE);
          break;
        case BLOCK:
          t = jj_consume_token(BLOCK);
          break;
        case RECORD:
          t = jj_consume_token(RECORD);
          break;
        default:
          jj_la1[12] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      columnSpec.put("COMPRESSION", t.image.toString());
        break;
      case IN_MEMORY:
        jj_consume_token(IN_MEMORY);
      columnSpec.put("IN_MEMORY", true);
        break;
      case BLOCK_CACHE_ENABLED:
        jj_consume_token(BLOCK_CACHE_ENABLED);
      columnSpec.put("BLOCK_CACHE_ENABLED", true);
        break;
      case TTL:
        jj_consume_token(TTL);
        jj_consume_token(EQUALS);
        n = number();
      columnSpec.put("TTL", n);
        break;
      case BLOOMFILTER:
        jj_consume_token(BLOOMFILTER);
        jj_consume_token(EQUALS);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BLOOMFILTER:
          t = jj_consume_token(BLOOMFILTER);
          break;
        case COUNTING_BLOOMFILTER:
          t = jj_consume_token(COUNTING_BLOOMFILTER);
          break;
        case RETOUCHED_BLOOMFILTER:
          t = jj_consume_token(RETOUCHED_BLOOMFILTER);
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      columnSpec.put("BLOOMFILTER", t.image.toString());
        break;
      case VECTOR_SIZE:
        jj_consume_token(VECTOR_SIZE);
        jj_consume_token(EQUALS);
        n = number();
      columnSpec.put("VECTOR_SIZE", n);
        break;
      case NUM_HASH:
        jj_consume_token(NUM_HASH);
        jj_consume_token(EQUALS);
        n = number();
      columnSpec.put("NUM_HASH", n);
        break;
      case NUM_ENTRIES:
        jj_consume_token(NUM_ENTRIES);
        jj_consume_token(EQUALS);
        n = number();
      columnSpec.put("NUM_ENTRIES", n);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return columnSpec;}
    throw new Error("Missing return statement in function");
  }

  final public CreateCommand createCommand() throws ParseException {
  CreateCommand createCommand = new CreateCommand(this.out);
  String table = null;
  Map<String, Object> columnSpec = null;
  String column = null;
    jj_consume_token(CREATE);
    jj_consume_token(TABLE);
    table = identifier();
    createCommand.setTable(table);
    jj_consume_token(LPAREN);
    column = identifier();
    columnSpec = ColumnSpec();
    createCommand.addColumnSpec(column, columnSpec);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      column = identifier();
      columnSpec = ColumnSpec();
        createCommand.addColumnSpec(column, columnSpec);
    }
    jj_consume_token(RPAREN);
    {if (true) return createCommand;}
    throw new Error("Missing return statement in function");
  }

  final public AlterCommand alterCommand() throws ParseException {
  AlterCommand alterCommand = new AlterCommand(this.out);
  String table = null;
  String column = null;
  Map<String, Object> columnSpec = null;
    jj_consume_token(ALTER);
    jj_consume_token(TABLE);
    table = identifier();
    alterCommand.setTable(table);
    if (jj_2_1(2)) {
      jj_consume_token(ADD);
      column = identifier();
      columnSpec = ColumnSpec();
         alterCommand.setOperationType(AlterCommand.OperationType.ADD);
         alterCommand.addColumnSpec(column, columnSpec);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ADD:
        jj_consume_token(ADD);
        jj_consume_token(LPAREN);
      alterCommand.setOperationType(AlterCommand.OperationType.ADD);
        column = identifier();
        columnSpec = ColumnSpec();
      alterCommand.addColumnSpec(column, columnSpec);
        label_5:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[16] = jj_gen;
            break label_5;
          }
          jj_consume_token(COMMA);
          column = identifier();
          columnSpec = ColumnSpec();
          alterCommand.addColumnSpec(column, columnSpec);
        }
        jj_consume_token(RPAREN);
        break;
      case DROP:
        jj_consume_token(DROP);
        column = identifier();
      alterCommand.setOperationType(AlterCommand.OperationType.DROP);
      alterCommand.setColumn(column);
        break;
      case CHANGE:
        jj_consume_token(CHANGE);
        column = identifier();
        columnSpec = ColumnSpec();
      alterCommand.setOperationType(AlterCommand.OperationType.CHANGE);
      alterCommand.addColumnSpec(column, columnSpec);
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return alterCommand;}
    throw new Error("Missing return statement in function");
  }

  final public DropCommand dropCommand() throws ParseException {
  DropCommand drop = new DropCommand(this.out);
  List<String> tableList = null;
    jj_consume_token(DROP);
    jj_consume_token(TABLE);
    tableList = tableList();
     drop.setTableList(tableList);
     {if (true) return drop;}
    throw new Error("Missing return statement in function");
  }

  final public InsertCommand insertCommand() throws ParseException {
  InsertCommand in = new InsertCommand(this.out);
  List<String> columnfamilies = null;
  List<String> values = null;
  String table = null;
  String timestamp = null;
  Token t = null;
    jj_consume_token(INSERT);
    jj_consume_token(INTO);
    table = identifier();
     in.setTable(table);
    columnfamilies = getColumns();
     in.setColumnfamilies(columnfamilies);
    jj_consume_token(VALUES);
    values = getLiteralValues();
     in.setValues(values);
    jj_consume_token(WHERE);
    jj_consume_token(ROW);
    jj_consume_token(EQUALS);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_LITERAL:
      t = jj_consume_token(STRING_LITERAL);
      break;
    case QUOTED_IDENTIFIER:
      t = jj_consume_token(QUOTED_IDENTIFIER);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     in.setRow(t.image.substring(1, t.image.length()-1));
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIMESTAMP:
      jj_consume_token(TIMESTAMP);
      timestamp = getStringLiteral();
       in.setTimestamp(timestamp);
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    {if (true) return in;}
    throw new Error("Missing return statement in function");
  }

  final public DeleteCommand deleteCommand() throws ParseException {
  DeleteCommand deleteCommand = new DeleteCommand(this.out);
  List<String> columnList = null;
  Token t = null;
  String table = null;
    jj_consume_token(DELETE);
    columnList = columnList();
    deleteCommand.setColumnList(columnList);
    jj_consume_token(FROM);
    table = identifier();
    deleteCommand.setTable(table);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHERE:
      jj_consume_token(WHERE);
      jj_consume_token(ROW);
      jj_consume_token(EQUALS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING_LITERAL:
        t = jj_consume_token(STRING_LITERAL);
        break;
      case QUOTED_IDENTIFIER:
        t = jj_consume_token(QUOTED_IDENTIFIER);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
     deleteCommand.setRow(t.image.substring(1, t.image.length()-1));
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    {if (true) return deleteCommand;}
    throw new Error("Missing return statement in function");
  }

  final public SelectCommand selectCommand() throws ParseException {
  SelectCommand select = new SelectCommand(this.out, this.formatter);
  List<String> columns = null;
  String rowKey = "";
  String stopRow = "";
  String timestamp = null;
  int numVersion = 0;
  String tableName = null;
  int limit;
    jj_consume_token(SELECT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COUNT:
      jj_consume_token(COUNT);
      columns = getLiteralValues();
        select.setCountFunction(true);
      break;
    case ASTERISK:
    case ID:
    case INTEGER_LITERAL:
    case QUOTED_IDENTIFIER:
    case STRING_LITERAL:
      columns = columnList();
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(FROM);
    tableName = identifier();
     select.setColumns(columns);
     select.setTable(tableName);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STARTING:
    case WHERE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WHERE:
        jj_consume_token(WHERE);
        jj_consume_token(ROW);
        jj_consume_token(EQUALS);
       select.setWhere(true);
        break;
      case STARTING:
        jj_consume_token(STARTING);
        jj_consume_token(FROM);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      rowKey = getStringLiteral();
       select.setRowKey(rowKey);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNTIL:
        jj_consume_token(UNTIL);
        stopRow = getStringLiteral();
      select.setStopRow(stopRow);
        break;
      default:
        jj_la1[24] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[25] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIMESTAMP:
      jj_consume_token(TIMESTAMP);
      timestamp = getStringLiteral();
       select.setTimestamp(timestamp);
      break;
    default:
      jj_la1[26] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM_VERSIONS:
      jj_consume_token(NUM_VERSIONS);
      jj_consume_token(EQUALS);
      numVersion = number();
        select.setVersion(numVersion);
      break;
    default:
      jj_la1[27] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LIMIT:
      jj_consume_token(LIMIT);
      jj_consume_token(EQUALS);
      limit = number();
      try{
        select.setLimit(limit);
      }catch(ClassCastException ce) {
        {if (true) throw generateParseException();}
      }
      break;
    default:
      jj_la1[28] = jj_gen;
      ;
    }
    {if (true) return select;}
    throw new Error("Missing return statement in function");
  }

  final public EnableCommand enableCommand() throws ParseException {
  EnableCommand enableCommand = new EnableCommand(this.out);
  String table = null;
    jj_consume_token(ENABLE);
    table = identifier();
    enableCommand.setTable(table);
    {if (true) return enableCommand;}
    throw new Error("Missing return statement in function");
  }

  final public DisableCommand disableCommand() throws ParseException {
  DisableCommand disableCommand = new DisableCommand(this.out);
  String table = null;
    jj_consume_token(DISABLE);
    table = identifier();
    disableCommand.setTable(table);
    {if (true) return disableCommand;}
    throw new Error("Missing return statement in function");
  }

  final public ClearCommand clearCommand() throws ParseException {
  ClearCommand clear = new ClearCommand(this.out);
    jj_consume_token(CLEAR);
     {if (true) return clear;}
    throw new Error("Missing return statement in function");
  }

  final public List<String> getLiteralValues() throws ParseException {
  List<String> values = new ArrayList<String>();
  String literal = null;
    jj_consume_token(LPAREN);
    literal = getStringLiteral();
    if(literal != null) values.add(literal);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_6;
      }
      jj_consume_token(COMMA);
           literal = getStringLiteral();
           if(literal != null) values.add(literal);
    }
    jj_consume_token(RPAREN);
     {if (true) return values;}
    throw new Error("Missing return statement in function");
  }

  final public String getStringLiteral() throws ParseException {
  Token s;
  String value = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOTED_IDENTIFIER:
    case STRING_LITERAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING_LITERAL:
        s = jj_consume_token(STRING_LITERAL);
        break;
      case QUOTED_IDENTIFIER:
        s = jj_consume_token(QUOTED_IDENTIFIER);
        break;
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
     value = s.image.toString();
     {if (true) return value.substring(1,value.length() - 1);}
      break;
    case ASTERISK:
    case ID:
    case INTEGER_LITERAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        s = jj_consume_token(ID);
        break;
      case INTEGER_LITERAL:
        s = jj_consume_token(INTEGER_LITERAL);
        break;
      case ASTERISK:
        s = jj_consume_token(ASTERISK);
        break;
      default:
        jj_la1[31] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
     value = s.image.toString();
     {if (true) return value;}
      break;
    default:
      jj_la1[32] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String getColumn() throws ParseException {
  Token col;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASTERISK:
    case ID:
    case INTEGER_LITERAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        col = jj_consume_token(ID);
        break;
      case INTEGER_LITERAL:
        col = jj_consume_token(INTEGER_LITERAL);
        break;
      case ASTERISK:
        col = jj_consume_token(ASTERISK);
        break;
      default:
        jj_la1[33] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        {if (true) return col.image.toString();}
      break;
    case QUOTED_IDENTIFIER:
    case STRING_LITERAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case QUOTED_IDENTIFIER:
        col = jj_consume_token(QUOTED_IDENTIFIER);
        break;
      case STRING_LITERAL:
        col = jj_consume_token(STRING_LITERAL);
        break;
      default:
        jj_la1[34] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        {if (true) return col.image.substring(1,col.image.toString().length() - 1);}
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public List<String> getColumns() throws ParseException {
  List<String> values = new ArrayList<String>();
  String literal = null;
    jj_consume_token(LPAREN);
   literal = getColumn();
 if(literal != null) values.add(literal);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[36] = jj_gen;
        break label_7;
      }
      jj_consume_token(COMMA);
        literal = getColumn();
        if(literal != null) values.add(literal);
    }
    jj_consume_token(RPAREN);
     {if (true) return values;}
    throw new Error("Missing return statement in function");
  }

  final public List<String> tableList() throws ParseException {
  List<String> tableList = new ArrayList<String>();
  String table = null;
    table = identifier();
                         tableList.add(table);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[37] = jj_gen;
        break label_8;
      }
      jj_consume_token(COMMA);
      table = identifier();
      tableList.add(table);
    }
    {if (true) return tableList;}
    throw new Error("Missing return statement in function");
  }

  final public List<String> columnList() throws ParseException {
  List<String> columnList = new ArrayList<String>();
  String column = null;
    column = getColumn();
      if(column != null) {
        columnList.add(column);
      } else {
        {if (true) return columnList;}
      }
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[38] = jj_gen;
        break label_9;
      }
      jj_consume_token(COMMA);
      column = getColumn();
      columnList.add(column);
    }
    {if (true) return columnList;}
    throw new Error("Missing return statement in function");
  }

  final public int number() throws ParseException {
  Token t = null;
  Token minusSignedInt = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      minusSignedInt = jj_consume_token(ID);
      break;
    case INTEGER_LITERAL:
      t = jj_consume_token(INTEGER_LITERAL);
      break;
    default:
      jj_la1[39] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    if(minusSignedInt != null) {
      {if (true) return Integer.parseInt(minusSignedInt.image.toString());}
    } else {
      {if (true) return Integer.parseInt(t.image.toString());}
    }
    throw new Error("Missing return statement in function");
  }

  final public String identifier() throws ParseException {
  Token t = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      t = jj_consume_token(ID);
       {if (true) return t.image.toString();}
      break;
    case QUOTED_IDENTIFIER:
    case STRING_LITERAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case QUOTED_IDENTIFIER:
        t = jj_consume_token(QUOTED_IDENTIFIER);
        break;
      case STRING_LITERAL:
        t = jj_consume_token(STRING_LITERAL);
        break;
      default:
        jj_la1[40] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
       {if (true) return t.image.substring(1,t.image.toString().length() - 1);}
      break;
    default:
      jj_la1[41] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String appendIndicator(String columnName) throws ParseException {
  String column = columnName;
     {if (true) return (!column.endsWith(":") && column.indexOf(":") == -1)
     ? column + ":" : column;}
    throw new Error("Missing return statement in function");
  }

  final private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  final private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) return true;
    }
    return false;
  }

  final private boolean jj_3_1() {
    if (jj_scan_token(ADD)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  final private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(68)) {
    jj_scanpos = xsp;
    if (jj_scan_token(69)) return true;
    }
    return false;
  }

  final private boolean jj_3R_11() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  public HQLParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  public boolean lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[42];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0xf3ffe0,0xf3ffe1,0xf3ffe0,0x0,0x0,0x0,0x0,0x33dbc0,0x33dbc0,0x0,0x600,0x0,0x0,0x0,0x0,0x0,0x0,0x1000,0x0,0x80000000,0x0,0x2000000,0x0,0x3000000,0x8000000,0x3000000,0x80000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1cf1c000,0xe0000,0x3800000,0x1cf1c000,0x10,0x10,0x60000000,0x0,0x0,0x0,0x0,0x80002000,0x0,0x0,0x0,0x0,0x1,0x2,0x10,0x0,0x2000,0x2000,0x2000,0x0,0x2000,0x10,0x10,0x10,0x0,0x0,0x0,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x40,0x0,0x1,0x7,0x7,0x31,0x1,0x1,0x31,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x30,0x0,0x30,0x0,0x33,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x30,0x3,0x33,0x3,0x30,0x33,0x0,0x0,0x0,0x3,0x30,0x31,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  public HQLParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public HQLParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new HQLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public HQLParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new HQLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public HQLParser(HQLParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(HQLParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  final private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[71];
    for (int i = 0; i < 71; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 42; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 71; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

  final private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  final private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
