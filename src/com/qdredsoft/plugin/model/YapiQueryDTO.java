package com.qdredsoft.plugin.model;

import java.io.Serializable;

/**
 * query
 *
 * @date 2019/2/11 5:05 PM
 */
public class YapiQueryDTO extends ValueWraper implements Serializable {

  private String _id;

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public YapiQueryDTO() {
  }
}
