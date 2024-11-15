# Iva's Deli
## Project Description
### Iva's Deli is a software application designed to manage and process orders for a customizable deli shop. Customers can create personalized sandwiches, choose from a selection of drinks and chips, and view their order details in a streamlined interface. After confirming an order, it is uploaded to a CSV file, where all orders are saved, including the current one. This feature ensures that order history is maintained for easy reference and analysis.

## Key features include:

### Customizable Sandwich Options (bread types, meats, cheese, other toppings, sauces etc.)
### Drink and Chips Selection
### Real-time Order Summary and Price Calculation
### Order history saved in a CSV file upon confirmation

## Application Screenshots

### Main Ordering Interface
![img.png](../../../../../Images%20For%20Read%20Me/img.png)
## Sandwich Customization Screen
![img_4.png](../../../../../Images%20For%20Read%20Me/img_4.png)
## Drink Screen
![img_2.png](../../../../../Images%20For%20Read%20Me/img_2.png)
## Chips Screen
![img_3.png](../../../../../Images%20For%20Read%20Me/img_3.png)
## Order Summary Screen
![img_5.png](../../../../../Images%20For%20Read%20Me/img_5.png)

## Favorite Piece Of Code
![img_1.png](../../../../../Images%20For%20Read%20Me/img_1.png)

### Why? 

#### Automatic Timestamping for Receipts:

#### The saveReceipt method saves each order with a unique timestamp, using LocalDateTime to create a file name based on the exact date and time of the order. This ensures every receipt is saved as a unique file, which is practical for logging individual transactions and for retrieval based on date and time.
#### CSV Logging for Order Summaries:

#### The saveToCsv method appends each order to a single CSV file (DeliOrders.csv), which is useful for summarizing all orders in one place. Each entry includes the timestamp, total price, and detailed order content, making it easy to review all orders over time.

# Added Receipt Feature!

