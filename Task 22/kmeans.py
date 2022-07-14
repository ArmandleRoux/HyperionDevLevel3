#K-Means clustering implementation

from asyncio.windows_events import NULL
from cProfile import label
import matplotlib.pyplot as plt
import numpy as np
import csv
import random

"""
1. Read data from files to respective variables.
2. Choose 3 random points for centroids.
3. Calculate distance of each point to each controid.
4. Determine which centroid is closest and add the point
   to that centroids group in dictionary.
5. After all points are checked get the XY mean of each 
   group/cluster that has formed and set the return XY mean 
   as a new centroid.
6. Repeat steps 3, 4 and 5 for the amount of user specified
   iterations.
7. Show results visually with a graph displaying the clusters
   in different colours.
"""

# Function that computes the distance between two data points
def getDistance(x1, y1, x2, y2):
    return np.sqrt(((x2-x1)**2) + ((y2-y1)**2))

# function that reads data in from the csv files  
def readData(file_name):
    data_dict = {}
    with open(file_name, "rt", encoding="utf-8") as data:
        reader = csv.reader(data, delimiter=",")
        for i, row in enumerate(reader):
            if(i>0):
                data_dict[row[0]] = (row[1], row[2])
        return data_dict

# Function that finds the closest centroid to each point out of all the centroids
def findClosestCentroid(x_pos, y_pos, centroids):
    distances = []
    for centroid in centroids:
        distances.append(getDistance(x_pos, y_pos, centroid[0], centroid[1]))
    dist_arr = np.array(distances)
    index = distances.index(np.amin(dist_arr))
    return centroids[index]

# Function that returns the XY means of given x and y points.
def get_X_Y_mean(x_points, y_points):
    return (np.mean(x_points), np.mean(y_points))

# Function to visualise the clusters.
def display_clusters(clusters_dict):
    plt.xlabel("Birth Rate(per 1000)")
    plt.ylabel("Life Expectancy")
    colour_list = ["r", "b", "g", "y", "orange", "brown", "purple", "gray", "pink", "black"]
    for i, cluster in enumerate(clusters_dict):
        for points in clusters_dict[cluster]:
            x_points.append(points[0])
            y_points.append(points[1]) 
        plt.scatter(x_points, y_points, c=colour_list[i] , label="Cluster"+str(i+1))
        x_points.clear()
        y_points.clear()
    plt.legend()
    plt.show()
    
# Function to return a key of a certain value in a dictionary.
def get_key(val, dict):
    for key, value in dict.items():
        if val == (float(value[0]) , float(value[1])):
            return key
    return "key doesn't exist"


dataDict = {}
         
# Request input from user to select a dataset to use
# and to enter the amount of clusters and iterations.
while True:
    dataset = input("Choose a dataset: \n"
                    + "1: 1953\n"
                    + "2: 2008\n"
                    + "3: Both\n"
                    + "0: Quit\n")

    if(dataset == "0" or dataset.lower == "quit"):
        break

    if(dataset == "1" or dataset == "1953"):
        data_Dict = readData("data1953.csv")
    elif(dataset == "2" or dataset == "2008"):
        data_Dict = readData("data2008.csv")
    elif(dataset == "3" or dataset == "both"):
        data_Dict = readData("databoth.csv")
        
    results_dict = []
    k_value = int(input("Please enter amount of clusters between 1 and 10: \n"))
    data_points = []

    # Read data to respective lists and arrays.
    birth_rate = []
    life_expectency = []
    for key in data_Dict:
        birth_rate.append(float(data_Dict[key][0]))
        life_expectency.append(float(data_Dict[key][1]))
        data_points.append((float(data_Dict[key][0]), float(data_Dict[key][1])))    
    br_arr = np.array(birth_rate)
    le_arr = np.array(life_expectency)

    centroids = []
    cluster_dict = {}
    centroids = random.sample(data_points, k_value)

    # Add centroid points as keys in dictionary to contain
    # cluster groups.
    for centroid in centroids:
        cluster_dict[centroid] = []
        
    for i in range(len(br_arr)) and range(len(le_arr)):
        closest = findClosestCentroid(br_arr[i], le_arr[i], centroids)
        cluster_dict[closest].append((br_arr[i], le_arr[i]))
        
    results_dict.append(cluster_dict)

    iterations = int(input("Please enter the amount of iterations: \n"))
    for i in range(iterations):
        centroids.clear()
        x_points = []
        y_points = []
        for i, cluster in enumerate(cluster_dict):
            if (len(cluster_dict[cluster])) > 0:
                for point in cluster_dict[cluster]:
                    x_points.append(point[0]) 
                    y_points.append(point[1])
                centroids.append(get_X_Y_mean(x_points, y_points))
            else:
                centroids.append(random.sample(data_points, 1)[0])
              
        # Clear current clusters and add new centroid point
        # gotten from mean of each cluster.  
        cluster_dict.clear()                
        for centroid in centroids:
            cluster_dict[centroid] = []
            
                
        for i in range(len(br_arr)):
            closest = findClosestCentroid(br_arr[i], le_arr[i], centroids)
            cluster_dict[closest].append((br_arr[i], le_arr[i]))

        results_dict.append(cluster_dict)
        
    x_points.clear()
    y_points.clear()    
    
    # Print out the results for questions
    #1.) The number of countries belonging to each cluster
    #2.) The list of countries belonging to each cluster
    #3.) The mean Life Expectancy and Birth Rate for each cluster
    for i, cluster in enumerate(cluster_dict):
        print("Cluster " + str(i + 1) + ": ")
        countries = []
        for point in cluster_dict[cluster]:
            country = get_key(point, data_Dict)
            countries.append(country)
            x_points.append(point[0])
            y_points.append(point[1])
        countries.sort()
        if(dataset == "3" or dataset == "both"):
            countries_1953 = []
            countries_2008 = []
            for country in countries:
                if "1953" in country:
                    countries_1953.append(country)
                elif "2008" in country:
                    countries_2008.append(country)

            print("Total countries: 1953:" 
                  + str(len(countries_1953))
                  + "  2008: " + str(len(countries_2008)))
            print("1953 Countries: " + str(countries_1953))
            print("-"*80)
            print("2008 Countries: " + str(countries_2008))

                    
        else:
            print("Total countries: " + str(len(cluster_dict[cluster])))
            print("Countries: " + str(countries))
        xy_mean = get_X_Y_mean(x_points, y_points)
        print("Birth Rate mean: " + str(cluster[0]))
        print("Life Expectancy mean: " + str(cluster[1]))
        
        print("-"*100)
        
    display_clusters(cluster_dict)