# cardGame
A multi-threaded card playing simulation in java for ECM2414 Software Development.

# Task specification
The game has *n* players, each numbered 1 to *n*, with *n* being a positive integer, and *n* decks of cards, again, each numbered 1 to *n*. Each player will hold a hand of 4 cards. Both these hands and the decks will be drawn from a **pack** which contains 8*n* cards. Each card has a face value (denomination) of a non- negative integer.

The decks and players will form a ring topology. At the start of the game, each player will be distributed four cards in a round-robin fashion, from the top of the pack, starting by giving one card to player1, then one card to player2, etc. After the hands have been distributed, the decks will then be filled from the remaining cards in the pack, again in a round-robin fashion.

To win the game, a player needs four cards of the same value in their hand. If a player is given four cards which are all the same value at the start of the game, they should immediately declare this (by their thread printing “Player *i* wins”, where i should be replaced with the player index), that player thread should then notify the other threads, and exit.

If the game is not won immediately, then the game progresses as follows: each player picks a card from the top of the deck to their left, and discards one to the bottom of the deck to their right. This process continues until the first player declares that they have four cards of the same value, at which point the game ends.

# Game playing strategy
If a player does not start with a winning hand, they will implement a simple game strategy, as specified below (note, the strategy is not optimal).

Each player will prefer certain card denominations, which reflect their index value, e.g., player1 will prefer 1s, player2 will prefer 2s, etc. After drawing a card from their left, a player will discard one of their cards to the deck on their right, (e.g. player1 will draw from deck1 and discard to deck2). The card they discard must display a value which is **not** of their preferred denomination. Additionally, a player **must not** hold onto a non-preferred denomination card indefinitely, so you must implement your Player class to reflect this restriction (otherwise the game may stagnate).
