package ua.room414.util;

import org.aspectj.lang.annotation.Aspect;

/**
 * Every time the bookTicket method is executed perform the checkLucky method for
 * the user that based on some randomness will return true or false. If user is lucky,
 * the ticketPrice changes to zero and ticket is booked, thus user pays nothing.
 * Store the information about this lucky event into the
 * user object (like some system messages or so)
 *
 * @author Alexander Melashchenko
 * @version 1.0 20 Jun 2017
 */
@Aspect
public class LuckyWinnerAspect {
}
