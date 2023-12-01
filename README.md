# SIR-Licious | Sandwhich Shop

**Created By:**
- Randy Lopez
- Igor "Ivan" Tavarez
- Chanthapone "Sing" Tuttanon

## Table of Contents:
- [Overview](#overview)
- [Project Structure](#project-structure)
- [Project Diagram](#project-diagram)
- [Code Highlight](#code-highlight)
- [Resources](#resources)

## Overview

**Development**

Our team collectively developed the SIR-Licious application, aiming to deliver a user-friendly and efficient ordering system. 

**Application**

SIR-Licious, is a Sandwich ordering application that allows customers (users) to create a custom sandwich order(s) with various options for bread type, toppings, drinks, and chips. The application provides a user-friendly interface to add items to an order, review the order, and proceed to checkout.


## Project Structure 

Screens | Package
- **Main:** Main class for entrypoint of the application.
- **MainMenu:** Handles the main menu interface.

![Main](src/main/resources/DemoPictures/MainSreen.png)

- OrderMenu: Provide functionality for customers to place orders.

![Order](src/main/resources/DemoPictures/OrderScreen.png)


Support | Sub-Package under "Screens"
- **Order:** Manages the order information, including items such as sandwich(es), drink(s), and chip(s).
- **CheckOut:** Handles the checkout process, including order summary, total cost calculation, and file handling for reading and writing orders.

Sandwich | Package
- **Sandwich:** Holds information for type of bread, toppings, and whether the sandwich is toasted. Additionally,sandwich cost calculations.
- **Bread:** Represents different sizes and types of bread for sandwich(es).

Toppings | Sub-Package under "Sandwich"
- **Toppings (Interface):** Defines the contract for toppings.
- **PremiumToppings:** Represents premium toppings. Provides lists of cheese and meat toppings for sandwiches.

![Meat](src/main/resources/DemoPictures/Meats.png)

![Cheese](src/main/resources/DemoPictures/Cheese.png)

- **RegularToppings:** Represents regular toppings. Provides lists of regular toppings (Vegetables, Sauces, Sides).

![Veggies](src/main/resources/DemoPictures/Veggies.png)

![Sauces](src/main/resources/DemoPictures/Sauces.png)

![Sides](src/main/resources/DemoPictures/Sides.png)

Combo | Package
- **Chips:** Represents various types of chips available for orders.

![Chips](src/main/resources/DemoPictures/Chips.png)

- **Drinks:** Represents different drink options and sizes.

![Drinks](src/main/resources/DemoPictures/Drinks.png)

## Project Diagram
![Diagram](src/main/resources/DemoPictures/Capstone-Diagram.png)

## Code Highlight
![highlight](src/main/resources/DemoPictures/Highlight.png)

