## Hotel Bookings
A simple hotel booking system keeps track of the rooms in a hotel. A guest can book a room for
individual nights and the booking system maintains the state of these bookings.
Guests are identified by their surname which, for the purposes of this exercise, can be considered
unique.
Rooms are identified by their room number taken from an arbitrary, potentially non-sequential set
of numbers. For example, a hotel might have four rooms {101, 102, 201, 203}.
The booking system may be used by a number of hotel staff at once, so must be thread-safe.<br/>