import numpy as np
import matplotlib.pyplot as plt

from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

# You can use polynomial regression on the price of potatoes to 
# the weight of the bag. Because potatoes get cheaper the more 
# you buy a polynomial model will fit the data better than a
# linear model would

# Training set
x_train = [[1], [2], [3], [5], [7]] # Weight of potato bag(kg)
y_train = [[16], [35], [40], [50], [55]] # prices of bags in Rands

# Testing set
x_test = [[4], [6], [8]] # Weight of potato bag(kg)
y_test = [[46], [53], [58]] # prices of bags in Rands

# Train the Linear Regression model and plot a prediction
regressor = LinearRegression()
regressor.fit(x_train, y_train)
xx = np.linspace(0, 26, 100)
yy = regressor.predict(xx.reshape(xx.shape[0], 1))
plt.plot(xx, yy)

# Set the degree of the Polynomial Regression model
quadratic_featurizer = PolynomialFeatures(degree=2)

# Transforms input data matrix into a new data matrix of a given degree
X_train_quadratic = quadratic_featurizer.fit_transform(x_train)
X_test_quadratic = quadratic_featurizer.transform(x_test)

# Train and test the regressor_quadratic model
regressor_quadratic = LinearRegression()
regressor_quadratic.fit(X_train_quadratic, y_train)
xx_quadratic = quadratic_featurizer.transform(xx.reshape(xx.shape[0], 1))

# Plot the graph
plt.plot(xx, regressor_quadratic.predict(xx_quadratic), c='r', linestyle='--')
plt.title('Price of potatoes to bag weight')
plt.xlabel('Weight (kg)')
plt.ylabel('Price in Rands')
plt.axis([0, 10, 0, 100])
plt.grid(True)
plt.scatter(x_train, y_train)
plt.show()
print(x_train)
print(X_train_quadratic)
print(x_test)
print(X_test_quadratic)