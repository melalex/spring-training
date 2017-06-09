package ua.room414.domain.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@XmlEnum
@XmlType(name = "eventRating")
public enum  EventRating {
    LOW,
    MID,
    HIGH
}
